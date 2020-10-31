<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new"/>
<c:url var ="NewURL" value="/admin-new"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách lớp học</title>
	</head>

	<body>
		<div class="main-content">
		<form action="<c:url value='/admin-class'/>" id="formSubmit" method="post">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Trang chủ</a>
							</li>
						</ul>
						<!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
								</c:if>
								<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value="/admin-class?type=add"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table class="table table-striped table-bordered" id="dataTables">
												<thead>
													<tr>
														<th><input type="checkbox" id="checkAll"></th>
														<th>Class Code</th>
														<th>Class Name</th>
														<th>Majors</th>
														<th>Options</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="item" items="${listclass}">
														<tr>
															<td><input type="checkbox" id="checkbox_${item.class_code}" value="${item.class_code}"></td>
															<td>${item.class_code}</td>
															<td>${item.class_name}</td>
															<td>${item.class_majors.majors_name}</td>
															<td>
																<div class="hidden-sm hidden-xs action-buttons">
																	<a class="green" href="#">
																		<i class="ace-icon fa fa-toggle-on bigger-130"></i>
																	</a>
																	<c:url var="viewURL" value="/web-class">
																		<c:param name="type" value="listStudent"/>
																		<c:param name="id" value="${item.class_code}"/>
																	</c:url>
																	<a class="orange" href='${viewURL}'>
																		<i class="ace-icon fa fa-search-plus bigger-130"></i>
																	</a>
																	<c:url var="editURL" value="/admin-class">
																		<c:param name="type" value="edit"/>
																		<c:param name="id" value="${item.class_code}"/>
																		
																	</c:url>
																	<a class="blue" href='${editURL}'>
																		<i class="ace-icon fa fa-pencil bigger-130"></i>
																	</a>
																	<a class="red" href="#">
																		<i class="ace-icon fa fa-trash-o bigger-130"></i>
																	</a>
																</div>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
											<input type="hidden" value="" id="page" name="page"/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</form>
		</div>
	</body>

	</html>