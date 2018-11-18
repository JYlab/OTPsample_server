<%@ page import="java.security.*" %>
<%@ page import="java.util.*" %>
<%@ page import="io.github.jylab.otpsvr.*" %>
<%@ page import="io.github.jylab.otpsvr.util.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%


String recvUUID = request.getParameter("uuid");
System.out.println("recvUUID : " + recvUUID);

OTP.init(1);
OTP.getUniqInfo(recvUUID);
byte [] bytes_otp = OTP.generateOTP();
String otpNumber = Base64Coder.encodeLines(bytes_otp).substring(0,6);
System.out.println("otpNumber : " + otpNumber);

%>
<%=otpNumber%>

