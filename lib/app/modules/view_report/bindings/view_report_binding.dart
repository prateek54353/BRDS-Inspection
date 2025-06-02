import 'package:get/get.dart';
import '../controllers/view_report_controller.dart';

class ViewReportBinding extends Bindings {
  @override
  void dependencies() {
    Get.lazyPut<ViewReportController>(
      () => ViewReportController(),
    );
  }
} 