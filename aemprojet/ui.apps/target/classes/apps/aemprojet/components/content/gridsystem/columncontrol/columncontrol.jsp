<jsp:directive.include file="/libs/foundation/global.jsp"/>
<cq:includeClientLib categories="bootstrap" />
<jsp:directive.page session="false" />

<jsp:scriptlet>
	pageContext.setAttribute("coltype", xssAPI.filterHTML(properties.get("coltype","")));
</jsp:scriptlet>

<c:if test="${empty coltype}">
	This is column control component
</c:if>

<c:if test="${not empty coltype}">
<style>
		.demo-border-blue{
    border:1px solid #0066FF;
} 
        .demo-border-black{
    border:1px solid #000000;
} 
        .demo-border-green{
    border:1px solid #19D1A3;
} 
        .demo-border-red{
    border:1px solid #FF4D4D;
} 
    </style>
<c:set var = "column" value = "${properties.coltype}" />
<c:set var = "color" value = "${properties.color}" />
<div class="row">
	<c:choose>
        <c:when test="${coltype eq '10-2-col'}">
		  	<div class="col-sm-10 ${color}" ><cq:include path="col-10-2-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-2 ${color}"><cq:include path="col-10-2-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
         <c:when test="${coltype eq '2-10-col'}">
		  	<div class="col-sm-2 ${color}" ><cq:include path="col-2-10-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-10 ${color}"><cq:include path="col-2-10-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '8-4-col'}">
		  	<div class="col-sm-8 ${color}" ><cq:include path="col-8-4-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-4 ${color}"><cq:include path="col-8-4-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '4-8-col'}">
	  		<div class="col-sm-4 ${color}"><cq:include path="col-4-8-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-8 ${color}"><cq:include path="col-4-8-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '4-4-4-col'}">
		  	<div class="col-sm-4 ${color}"><cq:include path="col-4-4-4-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-4 ${color}"><cq:include path="col-4-4-4-2" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-4 ${color}"><cq:include path="col-4-4-4-3" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '6-6-col'}">
		  	<div class="col-sm-6 ${color}"><cq:include path="col-6-6-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-6 ${color}"><cq:include path="col-6-6-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '3-3-3-3-col'}">
		  	<div class="col-sm-3  ${color}"><cq:include path="col-3-3-3-3-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-3  ${color}"><cq:include path="col-3-3-3-3-2" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-3  ${color}"><cq:include path="col-3-3-3-3-3" resourceType="/libs/foundation/components/parsys" /></div>
		 	<div class="col-sm-3  ${color}"><cq:include path="col-3-3-3-3-4" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '2-2-2-2-2-2-col'}">
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-1" resourceType="/libs/foundation/components/parsys" /></div>
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-2" resourceType="/libs/foundation/components/parsys" /></div>
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-3" resourceType="/libs/foundation/components/parsys" /></div>
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-4" resourceType="/libs/foundation/components/parsys" /></div>
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-5" resourceType="/libs/foundation/components/parsys" /></div>
			<div class="col-xs-6 col-sm-4 col-md-2 ${color}"><cq:include path="col-2-2-2-2-2-2-6" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '3-9-col'}">
			<div class="col-sm-3  ${color}"><cq:include path="col-3-9-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-9  ${color}"><cq:include path="col-3-9-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '9-3-col'}">
			<div class="col-sm-9  ${color}"><cq:include path="col-9-3-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-3  ${color}"><cq:include path="col-9-3-2" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '3-3-6-col'}">
			<div class=" col-sm-3 ${color}"><cq:include path="col-3-3-6-1" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class=" col-sm-3 ${color}"><cq:include path="col-3-3-6-2" resourceType="/libs/foundation/components/parsys" /></div>
		  	<div class="col-sm-6 ${color}"><cq:include path="col-3-3-6-3" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '6-3-3-col'}">
			<div class="col-sm-6  ${color}"><cq:include path="col-6-3-3-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-3  ${color}"><cq:include path="col-6-3-3-2" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-3  ${color}"><cq:include path="col-6-3-3-3" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
		<c:when test="${coltype eq '3-6-3-col'}">
			<div class="col-sm-3 ${color}"><cq:include path="col-3-6-3-1" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-6 ${color}"><cq:include path="col-3-6-3-2" resourceType="/libs/foundation/components/parsys" /></div>
	  		<div class="col-sm-3 ${color}"><cq:include path="col-3-6-3-3" resourceType="/libs/foundation/components/parsys" /></div>
		</c:when>
	</c:choose>
</div>
</c:if>