<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/masonry/3.3.2/masonry.pkgd.js"></script>

<body>
	<div id="container">
		<c:forEach items="${topicList}" var="topic">
	  		
 	 			<div class="item">
		 			${topic.topicName}</br> 
					<c:forEach items="${topic.topicDetail}" var="topicDetails">
						<li><a href="mathview?TOPICDETAILID=${topicDetails.topicDetailsID}"> ${topicDetails.topicDetailName} </a></li>
					</c:forEach>
				</div>
		
		</c:forEach>
	</div>
</body>

<script type="text/javascript">
	$( function() {

    	$('#container').masonry({
        	itemSelector: '.item',
        	columnWidth: 70
    	});

	});
</script>