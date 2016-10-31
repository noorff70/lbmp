<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/x-mathjax-config">
  MathJax.Hub.Config({tex2jax: {inlineMath: [['$','$'], ['\\(','\\)']]}});
</script>
<script type="text/javascript" async
	src="https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_CHTML"></script>


<script>
	$(document).ready(
			function() {
				$('#btn_checkAnswer').click(
						function() {
							
							 $('input[type=submit]').one('submit', function() {
							     $(this).attr('disabled','disabled');
							 });
							
							
							var answer = '';
							var answerValue = $("#id_answer").attr('value');
							var answerType = $("#id_answerType").attr('value');
							
	
							if (answerType == "FRACTION") {
								answer = $("#id_inputTextSingleAnswer").val();

								//Convert to JSON Object
								answer = JSON.stringify(answer).replace(/ /g, '');
								answerValue = JSON.stringify(answerValue).replace(/ /g, '');

								onClickCheckAnswer(answer, answerValue);

							} else if (answerType == "RADIOTYPE") {
								answer = $('input[name="myRadio"]:checked', '#topicdetailform').val();

								onClickCheckAnswer(answer, answerValue);

							} else {
								answer = $("#id_inputTextSingleAnswer").val();

								onClickCheckAnswer(answer, answerValue);
							}

						});

			});
</script>

<form:form id="topicdetailform" action="/lbmp/mathviewnext" method="post" modelAttribute="questionHeadingList">
	<input type="hidden" id="id_answerType" name="answerType" value="${lesson.problem.answer.type}">
	<input type="hidden" id="id_answer" name="answer" value="${lesson.problem.answer.answer}">
	<input type="hidden" id="id_answer_check" name="answerCheck" value="">

	<div class="container">
		<div class="row">
			<!-- This div holds the question and answer section -->
			<div class="col-xs-4">
				<div id="questionHeading" class="panel-heading text-center">
					<c:forEach var="questionHeading" items="${questionHeadingList}">
						<c:out value="${questionHeading}" />
						</br>
					</c:forEach>
				</div>
				<div id="idQuestion" class="panel-body" style="padding-right: 2cm">
					<div class="idQuestionLn"
						style="display: block; text-align: right; font-size: 14px; letter-spacing: 10px;"></div>
					<div class="form-group pull-right"></div>
				</div>
				</br> </br
				</br> </br>
				<div id="buttons">
					<button type="button" name="btn_checkAnswer" id="btn_checkAnswer">Check</button>
					<input type="submit" value="Next" onclick="doAjaxPost();" />
				</div>
			</div>

			<!-- This section will hold the statistics -->
			<div class="col-xs-4" id="id_statistics">
				

			</div>

			<!-- This section holds the description and other text issues -->
			<div class="col-xs-4">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									href="#collapseOne"> Objective </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">Test 1</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									href="#collapseTwo"> Strategy </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">Test 2</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle" data-toggle="collapse"
									href="#collapseThree"> Next Item </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse">
							<div class="panel-body">Test 3</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<div></div>


</form:form>
<script type="text/javascript">
	function doAjaxPost(type) {

		var data = {}
		data["noOfCorrectAnswer"] = $("#id_answer_check").val() ;

		$
				.ajax({
					type : "post",
					url : "/lbmp/mathviewnext",
					cache : false,
					contentType : "application/json",
					dataType : "JSON",
					data : JSON.stringify(data),

					success : function(response) {

						var numberOfQuestions = response.numberOfProblems;
						var numberOfRemainingProblems = response.remainingProblems;
						var questionheading = response.problem.questionHeading;
						var questionLines = response.problem.questionLines;
						var answer = response.problem.answer.answer;
						var answerType = response.problem.answer.type;
						var correctAnswers = response.numberOfCorrectAnswers;
						$('#id_answer_check').val(correctAnswers);

						$('#questionHeading').html("");
						//clear the question lines
						$(".idQuestionLn").remove();

						$(".radio").remove();
						//clear the text boxes
						$(".form-group").remove();
						//remove the single question line
						$("#id_inputTextSingleAnswer").remove();
						$('#id_form_group_statistics').remove();
						
						//replace the section with a new empty one.
						$('#id_statistics').append('<div class="form-group-statistics" id="id_form_group_statistics">'+
														'<div class="panel-body">' + 'Statistics </br>' + 
															'Total Questions: '+ numberOfQuestions + '</br>'+
															'Remaining Questions:' + numberOfRemainingProblems+ '</br>' +
															'No of Correct Answers:' + correctAnswers+ '</br>' +
														 '</div>' +
														'</div>');

						$('#id_form_group_answer').remove();								
						


						//append the question lines to question panel
						for (var i = 0; i < questionLines.length; i++) {

							var questionLine = questionLines[i];
							//if there is single line then just append the question
							if (questionLines.length == 1) {
								$('#idQuestion').append(
										'<div class= "idQuestionLn">'
												+ questionLine.questionLn
												+ '</div');
							} else {
								//for multiline questions show each question in a separate line
								if (answerType == "RADIOTYPE") {
									if (i == 0) {
										$('#idQuestion')
												.append(
														'<div class= "idQuestionLn ">'
																+ questionLine.questionLn
																+ '</div>');
									} else {
										$('#idQuestion')
												.append(
														'<div class="radio"><input type="radio"  name="myRadio" value='+ questionLine.questionLn+ ' /> '
																+ questionLine.questionLn
																+ '<br /></div>');
									}
								} else {
									$('#idQuestion').append(
											'<div class= "idQuestionLn" style="display:block ;text-align:right; ">'
													+ questionLine.questionLn
													+ '</div>');
								}
							}
						}

						//Get the answer
						$('#id_answer').val(answer);

						//Generate the answer text boxes

						$('#id_answerType').val(answerType)
						if (answerType == "RTL") {

							$('#idQuestion')
									.append(
											'<div class="form-group" style="display:inline-block float: right" ><label for="Answer:">Answer:</label>'
													+ '<input class="form-control input-sm" id="id_inputTextSingleAnswer" onkeyPress ="writeRTL(event)" type="text" dir="rtl"></div>');
						} else if (answerType == "FRACTION") {

							//format the question using math JAX
							var math = document.getElementById("idQuestion");
							MathJax.Hub.Queue([ "Typeset", MathJax.Hub, math ]);

							$('#idQuestion')
									.append(
											'<div class="form-group" style="display:inline-block float: right"><label for="Answer:">Answer:</label><input class="form-control input-sm" id="id_inputTextSingleAnswer" type="text"></div>');
						} else if (answerType == "RADIOTYPE") {

						} else {

							$('#idQuestion')
									.append(
											'<div class="form-group" style="display:inline-block float: right"><label for="Answer:">Answer:</label>'
													+ '<input class="form-control input-sm" id="id_inputTextSingleAnswer" type="text"></div>');
						}

					},
					error : function() {
						alert('Error while request..');
					}

				});
		event.preventDefault(); // prevent default posting of form
	}

	//This function will write from right to left.
	function writeRTL(e) {

		var Val = document.getElementById("id_inputTextSingleAnswer").value;

		var x = event.keyCode; // Get the Unicode value
		var newValue = String.fromCharCode(x);
		var secondHalf, realValue;

		if (event.keyCode == 44) {//when there is a comma
			secondHalf = document.getElementById("id_inputTextSingleAnswer").value;
			realValue = "," + secondHalf;
		} else if (Val.length > 0) {
			e.preventDefault();
			secondHalf = document.getElementById("id_inputTextSingleAnswer").value;
			realValue = newValue + secondHalf;
		}

		if (realValue.charAt(realValue.length - 1) == ',') {
			realValue = realValue.substr(0, realValue.length - 1);
		}
		$("#id_inputTextSingleAnswer").val(realValue);
	}

	function onClickCheckAnswer(answer, answerValue) {
		
		var value;
		var noOfCorrectAnswers=0;
		
		if (answer == answerValue){
			value = "Correct";
			noOfCorrectAnswers= $('#id_answer_check').val();
			noOfCorrectAnswers++;
		}
		else{
			value = "Wrong";
		}
		
		$('#id_answer_check').val(noOfCorrectAnswers);
		alert(noOfCorrectAnswers);

		$('#id_form_group_statistics').append('<div class="form-group-answer" id="id_form_group_answer">'+
				'<div class="panel-body">' + 'Result Section </br>' + 
					'Answer: '+ answerValue + '</br>'+
					'<label>Your answer is: </label>' + ' ' + '<label>'+ value  +'</label>'+
				 '</div>' +
				'</div>');

	}
</script>