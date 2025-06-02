import 'package:flutter/material.dart';
import 'package:get/get.dart';
import '../controllers/view_report_controller.dart';
import '../../../widgets/app_header.dart';

class ViewReportView extends GetView<ViewReportController> {
  const ViewReportView({super.key});

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
                  'View Report Page - Content Here',
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