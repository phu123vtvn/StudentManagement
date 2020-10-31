<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">New/Edit class</a>
                </li>
                <li class="active">Chỉnh sửa class</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form action="<c:url value='/admin-class'/>" method="post">
                        	<input type="hidden" value="view" id="id" name="type"/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Majors</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="categoryCode" name="majors">
                                        <c:if test="${empty listclass.class_majors.majors_code}">
                                            <option value="">Choose Class</option>
                                            <c:forEach var="item" items="${listmajors}">
                                                <option value="${item.majors_code}">${item.majors_name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty listclass.class_majors.majors_code}">
                                            <option value="">Choose Class</option>
                                            <c:forEach var="item" items="${listmajors}">
                                                <option value="${item.majors_code}" <c:if test="${item.majors_code == listclass.class_majors.majors_code}">selected="selected"</c:if>>
                                                        ${item.majors_name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Class Name</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="name" name="name" value="${listclass.class_name}" placeholder="Name"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty listclass.class_code}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật lớp" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty listclass.class_code}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm lớp" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${listclass.class_code}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
