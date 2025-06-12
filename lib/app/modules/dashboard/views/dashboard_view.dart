import 'package:flutter/material.dart';
import 'package:flutter/services.dart'; // For SystemNavigator
import 'package:get/get.dart';
import 'package:delightful_toast/delight_toast.dart';
import 'package:delightful_toast/toast/components/toast_card.dart';
import '../../../routes/app_pages.dart'; // For navigation
import '../controllers/dashboard_controller.dart';

class DashboardView extends StatefulWidget {
  const DashboardView({super.key});

  @override
  State<DashboardView> createState() => _DashboardViewState();
}

class _DashboardViewState extends State<DashboardView> {
  DateTime? lastPressedAt;
  @override
  Widget build(BuildContext context) {
    final DashboardController controller = Get.find<DashboardController>(); // Access controller
    final ThemeData theme = Theme.of(context);

    const Color _persistentGreen = Color(0xFF388E3C);
    const Color _persistentWhite = Colors.white;

    return PopScope(
      canPop: false,
      onPopInvokedWithResult: (bool didPop, dynamic result) {
        if (didPop) return;
        final now = DateTime.now();
        if (lastPressedAt == null || now.difference(lastPressedAt!) > const Duration(seconds: 2)) {
          lastPressedAt = now;
          DelightToastBar(
            autoDismiss: true,
            builder: (context) => const ToastCard(
              title: Text(
                "Press back again to exit",
                style: TextStyle(fontWeight: FontWeight.w700, fontSize: 14),
              ),
            ),
          ).show(context);
        } else {
          SystemNavigator.pop();
        }
      },
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Dashboard'),
          centerTitle: true,
          automaticallyImplyLeading: false,
        ),
      body: SafeArea(
        child: SingleChildScrollView(
          padding: const EdgeInsets.symmetric(horizontal: 0, vertical: 0),
          child: Column(
            children: [
                Card(
                  margin: const EdgeInsets.symmetric(horizontal: 4, vertical: 4),
                  child: Padding(
                    padding: const EdgeInsets.all(10.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Obx(() => Text(controller.currentDisplayedUserInfo['name']!,
                            style: theme.textTheme.titleMedium?.copyWith(fontWeight: FontWeight.bold))),
                        const SizedBox(height: 4),
                        Row(
                          children: [
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Obx(() => Text('जिला: ${controller.currentDisplayedUserInfo['zilla']!}', style: theme.textTheme.bodySmall)),
                                  const SizedBox(height: 2),
                                  Obx(() => Text('पंचायत: ${controller.currentDisplayedUserInfo['panchayat']!}', style: theme.textTheme.bodySmall)),
                                ],
                              ),
                            ),
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Obx(() => Text('विभाग: ${controller.currentDisplayedUserInfo['vibhaag']!}', style: theme.textTheme.bodySmall)),
                                  const SizedBox(height: 2),
                                  Obx(() => Text('प्रखण्ड: ${controller.currentDisplayedUserInfo['prakhand']!}', style: theme.textTheme.bodySmall)),
                                ],
                              ),
                            ),
                          ],
                        ),
                      ],
                    ),
                  ),
                ),

             Padding(
                  padding: const EdgeInsets.symmetric(vertical: 0),
                child: ClipRRect(
                  child: Image.asset('assets/plant.jpg', height: 178, width: double.infinity, fit: BoxFit.cover),
                ),
              ),
              const SizedBox(height: 1),
              
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8),
                child: ElevatedButton.icon(
                  style: ElevatedButton.styleFrom(
                      backgroundColor: _persistentGreen,
                      foregroundColor: _persistentWhite,
                    minimumSize: const Size.fromHeight(40),
                    shape: const RoundedRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(8.0))),
                    ),
                    icon: const Icon(Icons.cloud_download),
                    label: const Text('सर्वर से डेटा लोड करें', style: TextStyle(fontSize: 16)),
                    onPressed: controller.reloadDataFromServer,
                  ),
                ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 2.0),
                child: Align(
                  alignment: Alignment.centerLeft,
                  child: ElevatedButton(
                    style: ElevatedButton.styleFrom(
                        backgroundColor: theme.colorScheme.surfaceContainerLowest,
                        foregroundColor: theme.colorScheme.onSurfaceVariant,
                        elevation: 0,
                      shape: RoundedRectangleBorder(
                        borderRadius: const BorderRadius.all(Radius.circular(5.0)),
                          side: BorderSide(color: theme.colorScheme.outlineVariant.withAlpha((0.3 * 255).round()), width: 0.8)
                      ),
                        padding: const EdgeInsets.symmetric(horizontal: 12.0, vertical: 10.0),
                        textStyle: theme.textTheme.bodyLarge?.copyWith(color: theme.colorScheme.onSurfaceVariant)
                    ),
                    onPressed: () {
                      Get.toNamed(Routes.OTHERDISTRICT);
                    },
                    child: const Text('अतिरिक्त प्रभार (अन्य क्षेत्र)'),
                  ),
                ),
              ),
              Padding(
                  padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 4.0),
                child: ExpansionTile(
                    title: Text('वृक्षारोपण उत्तरजीविता प्रतिवेदन', style: theme.textTheme.bodyLarge?.copyWith(color: theme.colorScheme.onSurfaceVariant)),
                  initiallyExpanded: true,
                  childrenPadding: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 4.0),
                    tilePadding: const EdgeInsets.symmetric(horizontal: 12.0),
                    collapsedBackgroundColor: theme.colorScheme.surfaceContainerLowest,
                    backgroundColor: theme.colorScheme.surfaceContainerLowest,
                  shape: RoundedRectangleBorder(
                      borderRadius: const BorderRadius.all(Radius.circular(5.0)),
                      side: BorderSide(color: theme.colorScheme.outlineVariant.withAlpha((0.3 * 255).round()), width: 0.8)
                  ),
                  collapsedShape: RoundedRectangleBorder(
                      borderRadius: const BorderRadius.all(Radius.circular(5.0)),
                      side: BorderSide(color: theme.colorScheme.outlineVariant.withAlpha((0.3 * 255).round()), width: 0.8)
                  ),
                  children: <Widget>[
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        _DashboardActionButton(
                          icon: Icons.assignment,
                          label: 'प्रतिवेदन करें',
                            onTap: controller.navigateToReportWithDataCheck,
                        ),
                        _DashboardActionButton(
                          icon: Icons.cloud_upload,
                          label: 'अपलोड करें',
                          onTap: () => Get.toNamed(Routes.UPLOAD),
                        ),
                        _DashboardActionButton(
                          icon: Icons.assignment_turned_in,
                          label: 'रिपोर्ट देखें',
                          onTap: () => Get.toNamed(Routes.VIEW_REPORT),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
                const SizedBox(height: 8),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 16.0),
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                      backgroundColor: _persistentGreen,
                      foregroundColor: _persistentWhite,
                    minimumSize: const Size.fromHeight(40),
                    shape: const RoundedRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(8.0))),
                    textStyle: const TextStyle(fontSize: 16, fontWeight: FontWeight.w500)
                  ),
                  onPressed: () => Get.toNamed(Routes.CHANGE_PASSWORD),
                  child: const Text('Change Password'),
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 8.0, vertical: 8.0),
                child: OutlinedButton.icon(
                  style: OutlinedButton.styleFrom(
                    foregroundColor: theme.colorScheme.error,
                    side: BorderSide(color: theme.colorScheme.error),
                      minimumSize: const Size.fromHeight(40),
                    shape: const RoundedRectangleBorder(borderRadius: BorderRadius.all(Radius.circular(8.0))),
                  ),
                  icon: const Icon(Icons.logout),
                  label: const Text('Logout', style: TextStyle(fontSize: 16)),
                    onPressed: controller.logoutUser,
                ),
              ),
                const SizedBox(height: 8),
            ],
          ),
        ),
      ),
    )
  ); // PopScope closes here
  }
}
class _DashboardActionButton extends StatelessWidget {
  final IconData icon;
  final String label;
  final VoidCallback? onTap;

  const _DashboardActionButton({
    required this.icon,
    required this.label,
    this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    final ThemeData theme = Theme.of(context); // Keep theme for text styles if needed
    const Color backgroundColor = Color(0xFF388E3C); // Hardcoded green
    const Color foregroundColor = Colors.white; // Explicitly white as per image

    return GestureDetector(
      onTap: onTap,
      child: Card(
        color: backgroundColor,
        elevation: 1.0, // Subtle elevation, image buttons look fairly flat
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(10.0), // Rounded corners like image
        ),
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 10.0, vertical: 12.0), // Adjusted padding
          child: SizedBox(
            width: 85, // Adjusted width to make buttons somewhat uniform and compact
            child: Column(
              mainAxisSize: MainAxisSize.min,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Icon(icon, size: 28, color: foregroundColor), // Adjusted icon size
                const SizedBox(height: 6), // Space between icon and text
                Text(
                  label,
                  textAlign: TextAlign.center,
                  style: theme.textTheme.bodySmall?.copyWith( // Using bodySmall for smaller text
                    color: foregroundColor,
                    fontWeight: FontWeight.bold, // Make text bold as in image
                  ),
                  maxLines: 2, // Allow text to wrap if needed
                  overflow: TextOverflow.ellipsis, // Handle overflow
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}