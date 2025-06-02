import 'package:flutter/material.dart';
import 'package:get/get.dart';

import '../controllers/home_controller.dart';
import '../../../widgets/app_header.dart';
import '../../../widgets/app_footer.dart';
import '../../dashboard/views/dashboard_view.dart';

class HomeView extends GetView<HomeController> {
  const HomeView({super.key});

  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      backgroundColor: Colors.white,
      body: SafeArea(
        child: Column(
          children: [
            AppHeader(),
            Expanded(
              child: DashboardView(),
            ),
            AppFooter(),
          ],
        ),
      ),
    );
  }
}

