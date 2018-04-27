<%@include file="/apps/aemprojet/components/content/shared/global.jsp" %>
<%
    pageContext.setAttribute("searchPage", properties.get("searchPage", currentPage.getPath()));
%>
<cq:includeClientLib categories="aemprojet.site"/>

<form class="usa-search usa-search-small" action="${searchPage}.html">
    <div role="search">
        <label for="search-field-small" style="display: none;">Search:</label>
        <input id="search-field-small" type="search" name="q">
        <button value="Search" type="submit">
            <span class="usa-sr-only">Search</span>
        </button>
    </div>
</form>
