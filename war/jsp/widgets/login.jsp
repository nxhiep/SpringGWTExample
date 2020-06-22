<%@page import="com.spring.gwt.shared.model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserInfo currentUser = (UserInfo) request.getAttribute("currentUser");
%>
<script>
console.log('currentUser', '<%=currentUser != null ? currentUser.getAccount() : null%>');
</script>
<div class="login-panel">
<%if(!(currentUser != null && currentUser.isLogedIn())){ %>
<div class="modal fade" id="login-register-modal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div id="login-dialog" style="display:none;">
					<div>
						<label for="log-account">Tài khoản</label>
						<input 
						name="log-account" 
						id="log-account"
						placeholder="Tài khoản (*)" type="text" 
						autocomplete="name" 
						>
					</div>
					<div>
						<label for="log-password">Mật khẩu</label>
						<input 
						name="log-password" 
						id="log-password"
						placeholder="Mật khẩu (*)" type="text" 
						autocomplete="name" 
						>
					</div>
					<div>
						<button onclick="onLogin(this)">Đăng nhập</button>
						<button onclick="onLoginFacebook(this)">Đăng nhập Facebook</button>
					</div>
				</div>
				<div id="register-dialog" style="display:none;">
					<div>
						<label for="res-account">Tài khoản</label>
						<input 
						name="res-account" 
						id="res-account"
						placeholder="Tài khoản (*)" type="text" 
						autocomplete="name" 
						>
					</div>
					<div>
						<label for="res-email">Email</label>
						<input 
						name="res-email" 
						id="res-email"
						placeholder="Email (*)" type="text" 
						autocomplete="email" 
						>
					</div>
					<div>
						<label for="phoneNumber">Số điện thoại</label>
						<input 
						name="res-phone-number" 
						id="res-phone-number"
						placeholder="Số điện thoại" type="text" 
						autocomplete="tel" 
						>
					</div>
					<div>
						<label for="res-password">Mật khẩu</label>
						<input 
						name="res-password" 
						id="res-password"
						placeholder="Mật khẩu (*)" type="text" 
						autocomplete="name" 
						>
					</div>
					<div>
						<label for="res-repassword">Nhập lật khẩu</label>
						<input 
						name="res-repassword" 
						id="res-repassword"
						placeholder="Nhập lại mật khẩu (*)" type="text" 
						autocomplete="name" 
						>
					</div>
					<div>
						<button onclick="onRegister(this)">Đăng ký</button>
						<button onclick="onLoginFacebook(this)">Đăng nhập Facebook</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function openLoginDialog() {
		$('#login-dialog').show();
		$('#register-dialog').hide();
		$('#login-register-modal').modal();
	}
	function openRegisterDialog() {
		$('#register-dialog').show();
		$('#login-dialog').hide();
		$('#login-register-modal').modal();
	}
</script>
<%} %>
</div>