import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/upload_controller.dart';
import '../../../widgets/app_header.dart';

class UploadView extends GetView<UploadController> {
  const UploadView({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: null,
      body: SafeArea(
        child: Column(
          children: [
            const AppHeader(),
            const Expanded(
              child: Center(
                child: Text(
                  'Upload Page - Content Here',
                  style: TextStyle(fontSize: 20),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
class AppFooter extends StatelessWidget {
  const AppFooter({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      color: const Color(0xFF295C46), // Dark green from screenshot
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: const Center(
        child: Text(
          'Services provided by: NIC Bihar',
          style: TextStyle(color: Colors.white, fontSize: 15),
        ),
      ),
    );
  }
}