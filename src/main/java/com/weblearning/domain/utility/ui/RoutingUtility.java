package com.weblearning.domain.utility.ui;

public class RoutingUtility 
{
	
	public static String getViewPage(int subjectId)
	{
		switch (subjectId){
		
		case 1:
			return WebConstants.MATH_VIEW;
			
		case 2:
			return WebConstants.SOCIAL_STUDIES;
		
		}
		
		return null;
		
	}

}
