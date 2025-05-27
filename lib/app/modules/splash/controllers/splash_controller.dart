import 'package:get/get.dart';
import 'dart:async';
import 'package:myapp1/app/routes/app_pages.dart';

class SplashController extends GetxController {
  @override
  void onReady() {
    super.onReady();
    print('SplashController onReady called');
    Timer(const Duration(seconds: 2), () {
      print('Navigating to LOGIN...');
      Get.offAllNamed(Routes.LOGIN);
    });
  }
}
