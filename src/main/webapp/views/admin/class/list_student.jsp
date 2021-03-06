<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Trang chủ</title>
	</head>
	<body>
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
				<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm bài viết' href='<c:url value="/admin-student?type=add"/>'>
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
							<table class="table table-striped table-bordered" id="dataTables">
								<thead>
									<tr>
										<th>#</th>
										<th width="7%" scope="col">CODE</th>
										<th width="13%" scope="col">Name</th>
										<th width="15%" scope="col">Birth</th>
										<th width="7%" scope="col">Gender</th>
										<th width="25%" scope="col">Address</th>
										<th width="10%" scope="col">Class</th>
										<th width="13%" scope="col">Majors</th>
										<th width="10%" scope="col">Option</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${liststudent}" >
									<tr>
										<td><input type="checkbox" id="checkbox_${item.student_code}" value="${item.student_code}"></td>
										<td>${item.student_code}</td>
										<td>${item.student_name}</td>
										<td>${item.student_birth}</td>
										<td>${item.student_gender}</td>
										<td>${item.student_address}</td>
										<td>${item.student_class.class_name}</td>
										<td>${item.student_majors.majors_name}</td>
										<td>
											<div class="hidden-sm hidden-xs action-buttons">
												<a class="green" href="#">
													<i class="ace-icon fa fa-toggle-on bigger-130"></i>
												</a>
												<c:url var="editURL" value="/admin-student">
													<c:param name="type" value="edit"/>
													<c:param name="id" value="${item.student_code}"/>
													
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
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.main-content -->
	</body>
</html>