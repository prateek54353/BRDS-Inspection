import 'package:get/get.dart';
import '../services/auth_service.dart';

class InitialBinding extends Bindings {
  @override
  void dependencies() {
    // Initialize AuthService as a permanent service
    Get.putAsync<AuthService>(() => AuthService().init(), permanent: true);
  }
} 