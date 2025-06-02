import 'package:get/get.dart';
import '../controllers/inspection_form_controller.dart';

class InspectionFormBinding extends Bindings {
  @override
  void dependencies() {
    Get.lazyPut<InspectionFormController>(
      () => InspectionFormController(),
    );
  }
} 