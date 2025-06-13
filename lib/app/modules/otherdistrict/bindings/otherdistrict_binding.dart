import 'package:get/get.dart';

import '../controllers/otherdistrict_controller.dart';

class OtherdistrictBinding extends Bindings {
  @override
  void dependencies() {
    Get.lazyPut<OtherdistrictController>(
      () => OtherdistrictController(),
    );
  }
}
