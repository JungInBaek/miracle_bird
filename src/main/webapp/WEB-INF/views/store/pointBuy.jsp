<%@page import="com.multi.miraclebird.point.PointVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script type="text/javascript">
	$(function() {
		<%
		PointVO pointVO = (PointVO) request.getAttribute("pointVO");
		int pointId = pointVO.getPointId();
		int pointAmount = pointVO.getPointAmount();
		int pointPrice = pointVO.getPointPrice();
		
		String username = (String) request.getAttribute("username");
		%>
		var IMP = window.IMP; // 생략가능
		IMP.init('iamport'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		IMP.request_pay({
			pg : 'inicis', // version 1.1.0부터 지원.
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : "미라클 포인트 " + <%=pointPrice%> + "개",
			amount : <%=pointAmount%>,
			pointId : <%=pointId%>,
			buyer_email : 'iamport@siot.do',
			buyer_name : '<%=username%>',
			buyer_tel : '010-1234-5678',
			buyer_addr : '서울특별시 강남구 삼성동',
			buyer_postcode : '123-456',
			m_redirect_url : 'www.yourdomain.com/payments/complete'
		}, function(rsp) {
			if (rsp.success) {
				$.ajax({
					url : "pointBuying",
					type : "post",
					data : {
						pointId : <%=pointId%>
					},
					dataType : "json",
				})
				var msg = '결제가 완료되었습니다. \n';
				msg += '고유ID : ' + rsp.imp_uid + " \n";
				msg += '상점 거래ID : ' + rsp.merchant_uid + " \n";
				msg += '결제 금액 : ' + rsp.paid_amount + "원 \n";
				msg += '카드 승인번호 : ' + rsp.apply_num + " \n";
				
				alert(msg);
				location.href="pointList";
			} else {
				var msg = '결제에 실패하였습니다. \n';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
				location.href = "pointList";
			}
			
		});

	})
</script>
</head>
<body>

</body>
</html>