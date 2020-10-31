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
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
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
                        <form action="<c:url value='/admin-student'/>" method="post">
                        	<input type="hidden" value="view" id="id" name="type"/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Class</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="categoryCode" name="class">
                                        <c:if test="${empty student.student_class.class_code}">
                                            <option value="">Choose Class</option>
                                            <c:forEach var="item" items="${listClass}">
                                                <option value="${item.class_code}">${item.class_name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty student.student_class.class_code}">
                                            <option value="">Choose Class</option>
                                            <c:forEach var="item" items="${listClass}">
                                                <option value="${item.class_code}" <c:if test="${item.class_code == student.student_class.class_code}">selected="selected"</c:if>>
                                                        ${item.class_name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Name Student</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="name" name="name" value="${student.student_name}" placeholder="Name"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Birth Day</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="birth" name="birth" value="${student.student_birth}" placeholder="yyyy/mm/dd"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Gender</label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="gender" name="gender">
                                        <c:if test="${empty student.student_gender}">
                                            <option value="">Choose Gender</option>
                                            <option value="Nam">Nam</option>
                                            <option value="Nữ">Nữ</option>
                                        </c:if>
                                        <c:if test="${not empty student.student_gender}">
                                            <option value="">Choose Gender</option>
                                            <option value="Nam" <c:if test="${student.student_gender eq 'Nam'}">selected="selected"</c:if>>
                                                       Nam
                                            </option>
                                            <option value="Nữ" <c:if test="${student.student_gender eq 'Nữ'}">selected="selected"</c:if>>
                                                       Nữ
                                            </option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Address</label>
                                <div class="col-sm-6">                                 
                                    <textarea rows="" cols="" id="address" name="address" style="width: 820px;height: 175px">${student.student_address}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty student.student_code}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty student.student_code}">
                                        <input type="submit" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${student.student_code}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
