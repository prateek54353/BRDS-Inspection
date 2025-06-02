import 'dart:convert';

UserLogin userLoginFromJson(String str) => UserLogin.fromJson(json.decode(str));

String userLoginToJson(UserLogin data) => json.encode(data.toJson());

class UserDetail {
    final String? blockCode;
    final String? blockName;
    final String? department;
    final String? distName;
    final String? districtCode;
    final String? email;
    final String? isMobileUpdated;
    final String? lastVisitedOn;
    final String? mobileNo;
    final String? name;
    final String? panchayatCode;
    final String? panchayatName;
    final String? userrole;
    final String? isChangePassWord;
    final String? userId; // UserID from UserDetail, distinct from UserLogin.userId

    UserDetail({
        this.blockCode,
        this.blockName,
        this.department,
        this.distName,
        this.districtCode,
        this.email,
        this.isMobileUpdated,
        this.lastVisitedOn,
        this.mobileNo,
        this.name,
        this.panchayatCode,
        this.panchayatName,
        this.userrole,
        this.isChangePassWord,
        this.userId,
    });

    factory UserDetail.fromJson(Map<String, dynamic> json) => UserDetail(
        blockCode: json["BlockCode"],
        blockName: json["BlockName"],
        department: json["Department"],
        distName: json["DistName"],
        districtCode: json["DistrictCode"],
        email: json["Email"],
        isMobileUpdated: json["IsMobileUpdated"],
        lastVisitedOn: json["LastVisitedOn"],
        mobileNo: json["MobileNo"],
        name: json["Name"],
        panchayatCode: json["PanchayatCode"],
        panchayatName: json["PanchayatName"],
        userrole: json["Userrole"],
        isChangePassWord: json["isChangePassWord"],
        userId: json["UserID"], // From UserDetail fields
    );

    Map<String, dynamic> toJson() => {
        "BlockCode": blockCode,
        "BlockName": blockName,
        "Department": department,
        "DistName": distName,
        "DistrictCode": districtCode,
        "Email": email,
        "IsMobileUpdated": isMobileUpdated,
        "LastVisitedOn": lastVisitedOn,
        "MobileNo": mobileNo,
        "Name": name,
        "PanchayatCode": panchayatCode,
        "PanchayatName": panchayatName,
        "Userrole": userrole,
        "isChangePassWord": isChangePassWord,
        "UserID": userId,
    };
}

class UserLogin {
    final String? clientKey; // For request
    final String? userId;    // For request & response (this is the one used for login ID)
    final String? password;  // For request
    final String? deviceId;  // For request
    final String? ipAddress; // For request

    final String? authToken;       // From response
    final String? status;          // From response
    final String? message;         // From response
    final String? resultMessage;   // From response
    final UserDetail? userDetails; // From response

    UserLogin({
        // Request fields
        this.clientKey,
        this.userId, // This is the main UserID for login
        this.password,
        this.deviceId,
        this.ipAddress,
        // Response fields
        this.authToken,
        this.status,
        this.message,
        this.resultMessage,
        this.userDetails,
    });

    factory UserLogin.fromJson(Map<String, dynamic> json) => UserLogin(
        authToken: json["Authtoken"],
        userId: json["UserID"], // This is the UserID from the top level of UserLogin response
        status: json["Status"],
        message: json["Message"],
        resultMessage: json["ResultMessage"],
        userDetails: json["UserDetails"] == null ? null : UserDetail.fromJson(json["UserDetails"]),
    );

    Map<String, dynamic> toJsonForRequest() => {
        "ClientKey": clientKey,
        "UserID": userId, // This is the UserID used for login
        "Password": password,
        "DeviceId": deviceId,
        "IpAddress": ipAddress,
    };

    Map<String, dynamic> toJson() => {
        "Authtoken": authToken,
        "UserID": userId, // Top-level UserID
        "Status": status,
        "Message": message,
        "ResultMessage": resultMessage,
        "UserDetails": userDetails?.toJson(),
        "ClientKey": clientKey,
        "Password": password,
        "DeviceId": deviceId,
        "IpAddress": ipAddress,
    };
} 