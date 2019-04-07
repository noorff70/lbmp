# -*- coding: utf-8 -*-
"""
Created on Mon Apr 23 11:15:08 2018

@author: noorf
"""

# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import matplotlib.pyplot as plt, mpld3
import numpy as np
from collections import defaultdict
#import matplotlib.patheffects

#import base64
#from io import BytesIO
#from StringIO import StringIO
from flask import Flask, request, json, Response
#from sympy import Symbol
#from sympy import init_printing
from sympy.parsing.sympy_parser import parse_expr
from sympy import latex
from sympy import sympify
from matplotlib.lines import Line2D

from bokeh.plotting import figure
from bokeh.embed import json_item
from datetime import date
from random import randint
from bokeh.models import ColumnDataSource, LabelSet
from bokeh.models.widgets import DataTable, DateFormatter, TableColumn
from bokeh.io import output_file, show
from bokeh.layouts import widgetbox

from ast import literal_eval


app = Flask(__name__)

@app.route("/answers",  methods=["POST"])
def get_math_answers():
    ans = ""
    if request.headers['Content-Type'] == 'text/plain':
        #print (request.data)
        return 'OK', 200
    elif request.headers['Content-Type'] == 'application/json':
        #put json object in a dict
        problems = json.loads( json.dumps(request.json, indent =4))
        #print problems
        for problem in problems:
            if 'answer' in problem:
                if problem['answer']['answerList'] is not None:
                    for answerLn in problem['answer']['answerList']:
                        a = latex(sympify(answerLn['answerLn']))
                        answerLn['answerLn']  = "$" + a + "$"
            if 'questionLines' in problem:
                for qLn in problem['questionLines']:
                    if qLn['latexFormat'] == 'LATEXFORMAT':
                        b = latex((qLn['questionLn']))
                        qLn['questionLn'] = "$" + b + "$"
                    if qLn['latexFormat'] == 'PIPLOT':
                        fig, ax = plt.subplots()

                        # receive linelist
                        linelist = get_line_list(qLn['questionLn'])
                        anglelist = get_angle_list(qLn['questionLn'])
                        vertexlabels = get_vertex_label(qLn['questionLn'])
                        coordinatelist = get_coordinate_list(qLn['questionLn'])
                        
                        #print linelist
                        for ln in linelist:
                            #convert the string type to a tuple
                            line1 = literal_eval(ln)
                            #get the coordinates
                            line = Line2D(line1[0], line1[1])
                            ax.add_line(line)
                            
                        #print angles
                        for ang in anglelist:
                            
                            angleline = literal_eval(ang)
                            #print angleline

                            angle_plot = angleline[1]

                            #angleLine[5] is a laceholder if the angle will be shown of not
                            if angleline[1] == 'x':
                                ans = angleline[2]
                               

                            #angleline[4][0] is the x coordinate where it will be placed
                            if angle_plot != 90 :
                                ax.text (angleline[0][0], angleline[0][1], angle_plot)
                            

                        
                        for vlabel in vertexlabels:
                            vertexlabel = literal_eval(vlabel)
                            ax.text(vertexlabel[0][0], vertexlabel[0][1], vertexlabel[1])              
  
                        ax.set_aspect('equal')
                        ax.grid(True, which='both')
                        ax.axis([float(coordinatelist[0]), float(coordinatelist[1]), float(coordinatelist[2]), float(coordinatelist[3])]) 
                       
                        #plot = json.dumps(mpld3.fig_to_html(fig)) 
                        plot = json.dumps(mpld3.fig_to_dict(fig))
                        qLn['questionLn'] = plot

                        plt.gcf().clear()
            
            if 'answer' in problem:
                if problem['answer']['answer'] == 'Blank':
                    problem['answer']['answer'] = ans

        js = json.dumps(problems)
       
        resp = Response(js, status=200, mimetype='application/json')
        return resp             

    else:
        print ('Unsupported Type')
        return "Unsupported Media Type", 415

  
#get Line Coordinates from String and split that and store in a list ex:
#String question = line1 + "line" + line2 + "line" + line3;
#line1= [1,6], [0,0]
def get_line_list(s):
    #get upto angles delimeter; find the index of angles
    #beg = questionline.index("anglesbeg")
    #linelist = questionline[:beg]
    #linelist = linelist.split("line")
    first = '<linebeg>'
    last = '<lineend>'
    start = s.index( first ) + len( first )
    end = s.index( last, start )
    linelist = str(s[start:end])

    linelist = linelist.split('line')
    return   linelist 

#get vertex labels
def get_vertex_label(s):

    first = '<vertexbeg>'
    last = '<vertexend>'
    
    #split according to delimeter first and last
    start = s.index( first ) + len( first )
    end = s.index( last, start )
    anglelist = str(s[start:end])

    #split with "angle" and 
    vertexlabel = anglelist.split("vertice")
    return vertexlabel

def get_coordinate_list(coordinates):
    
    first = '<xyLimitbeg>'
    last = '<xyLimitend>'
    
    #split according to delimeter first and last
    start = coordinates.index( first ) + len( first )
    end = coordinates.index( last, start )
    coordinatelist = str(coordinates[start:end])

    coordinatelist = coordinatelist.split(",")

    
    return coordinatelist


#get angle coordinates from string REST
def get_angle_list(s):

    first = '<anglesbeg>'
    last = '<anglesend>'
    
    #split according to delimeter first and last
    start = s.index( first ) + len( first )
    end = s.index( last, start )
    anglelist = str(s[start:end])

    #split with "angle" and 
    anglelist = anglelist.split("angle")
    
    return anglelist



def get_angle_text(angle_plot):
    angle = angle_plot.get_label()[:-1] # Excluding the degree symbol
    angle = "%0.2f"%float(angle) # Display angle upto 2 decimal places
    # Get the vertices of the angle arc
    vertices = angle_plot.get_verts()
    #print vertices
    # Get the midpoint of the arc extremes
    x_width = (vertices[0][0] + vertices[-1][0]) / 2.0
    y_width = (vertices[0][0] + vertices[-1][0]) / 2.0

    #print x_width, y_width

    separation_radius = max(x_width/2.0, y_width/2.0)

    return [ x_width + separation_radius, y_width + separation_radius, angle]   



@app.route("/getExpressions",  methods=["POST"])
def get_math_expression():

    if request.headers['Content-Type'] == 'text/plain':
        #print (request.data)
        return 'OK', 200
    elif request.headers['Content-Type'] == 'application/json':
        #put json object in a dict
        problems = json.loads( json.dumps(request.json, indent =4))
        #print problems
        for problem in problems:
            if 'answer' in problem:
                if problem['answer']['expression'] is not None:
                    if problem['answer']['answerType'] == 'decimal':
                        #da = latex(sympify(problem['answer']['expression']))
                        da = parse_expr(problem['answer']['expression'])
                        da= round(da.evalf(),2)
                        #print round(da, 2)
                        problem['answer']['expression']  = latex(da) 
                    if problem['answer']['answerType'] == 'default':
                        da = latex(sympify(problem['answer']['expression']))
                        problem['answer']['expression']  = da 
        js = json.dumps(problems)
       
        resp = Response(js, status=200, mimetype='application/json')
        return resp             

    else:
        print ('Unsupported Type')
        return "Unsupported Media Type", 415
    

@app.route("/getGraph",  methods=["POST"])
def get_math_graph():
    
        
    problems = json.loads( json.dumps(request.json, indent =4))
    
     #update dataRange array
    for problem in problems:
                
        if problem['graphObject'] is not None:
                    
            if problem['graphObject']['graphType'] == 'PIBARGRAPH':
                                
                cols = []
                rows=[]
                                
                for legend in problem['graphObject']['colVals']:
                    cols.append(str(legend))  

                for dRange in problem['graphObject']['rowVals']:
                    rows.append(float(str(dRange)))
                
                for qLn in problem['questionLines']:
                    if qLn['latexFormat'] == 'PIPLOT':

                        p = figure(x_range=cols, plot_height=250, title="", sizing_mode='scale_width')
                        p.vbar(x=cols, top=rows, width=0.9)

                        p.xgrid.grid_line_color = None
                        p.y_range.start = 0
                        item_text = json.dumps(json_item(p))
                        
                        qLn['questionLn'] = item_text
                        
            elif problem['graphObject']['graphType'] == 'TABLE':
                
                #create an empty dictionary
                data = {}
                columns=[]
                
                variableList = json.loads( json.dumps(problem['graphObject']['variableList']))
                       
                for variable in variableList:
                    variableName = str(variable['variableName'])
                    values = [] #create list of values in a variable
                    for value in variable['valueList']:
                        values.append(str(value)) #add the value in variable
                        #create key and list of values in a dictionary
                        data[variableName]=values
                
                for variable in variableList:
                    variableName = str(variable['variableName'])

                    columns.append(TableColumn(field=variableName, title=variableName))

                    
                for qLn in problem['questionLines']:
                    
                    if qLn['latexFormat'] == 'PIPLOT':
                        
                        source = ColumnDataSource(data)

                        data_table = DataTable(source=source, columns=columns, width=400, height=100)
            
                        plot = json.dumps(json_item(data_table))
                        qLn['questionLn'] = plot
                        
        if problem['geometryObject'] is not None:
            
            # p.sizing_mode='scale_both'

            geoObject = problem['geometryObject']
            
            if geoObject['rangeXY'] is not None:
                rangeXY = geoObject['rangeXY']
                print(rangeXY['lowerX'],  rangeXY['upperX'])
                p = figure(title="", width=400, height=400, match_aspect=True, x_range=(rangeXY['lowerX'], rangeXY['upperX']), y_range=(rangeXY['lowerY'], rangeXY['upperY']))
            else: 
                p = figure(title="", width=400, height=400, match_aspect=True)
            
            if geoObject['circles'] is not None:
                x=[] 
                y=[]
                circles = geoObject['circles']
                for circle in circles:
                    x.append(circle['xCo'])
                    y.append(circle['yCo'])
                    
                p.circle(x, y, fill_color="red", size=8, )
                
            if geoObject['labels'] is not None:
                data={} #empty dictionary data
                xsVal=[]
                ysVal=[]
                labelsVal=[]

                for label in geoObject['labels']:
                   xsVal.append(label['xCo'])
                   ysVal.append(label['yCo'])
                   labelsVal.append(str(label['labelName']))
                   
                data['xs']= xsVal
                data['ys']= ysVal
                data['labels']= labelsVal
                source = ColumnDataSource(data=dict(xs=xsVal, ys=ysVal, names=labelsVal))
                #source = ColumnDataSource(data=dict(xs=[1, 5, 3], ys=[0, 0, 7],names=['A', 'B', 'C']))
                labs = LabelSet(x='xs', y='ys', text='names', source=source, render_mode='canvas')
                p.add_layout(labs)
                
            if geoObject['lines'] is not None:
                for ln in geoObject['lines']:
                    if ln['color'] is not None:
                        p.line([ln['x1'],ln['x2']],[ln['y1'],ln['y2']],line_width=2, color = ln['color'])
                    else:
                        p.line([ln['x1'],ln['x2']],[ln['y1'],ln['y2']],line_width=2)
                    
            if geoObject['patches'] is not None:
                x=[] 
                y=[]
                patches = geoObject['patches']
                for patch in patches:
                    xcoordinates = patch['coX']
                    for xco in xcoordinates:
                        x.append(xco)
                        
                for patch in patches:
                    ycoordinates = patch['coY']
                    for yco in ycoordinates:
                        y.append(yco)
                        
                p.patch(x, y, alpha=0.5, line_width=2)   

            
            for qLn in problem['questionLines']:
                if qLn['latexFormat'] == 'PIPLOT':
                    p.toolbar.logo = None
                    item_text = json.dumps(json_item(p))
                    qLn['questionLn'] = item_text
                    
    js = json.dumps(problems)
    resp = Response(js, status=200, mimetype='application/json')
    return resp 
    
 

if __name__ == "__main__":
    app.run()
