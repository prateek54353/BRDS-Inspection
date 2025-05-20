import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'dart:async';
import 'app/routes/app_pages.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Login App',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.system, //  Responds to system setting
      theme: ThemeData.light(),     //  Light theme
      darkTheme: ThemeData.dark(),  //  Dark theme
      home: const SplashScreen(),
      getPages: AppPages.routes,
    );
  }
}


class SplashScreen extends StatefulWidget {
  const SplashScreen({super.key});

  @override
  State<SplashScreen> createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    super.initState();
    Timer(const Duration(seconds: 3), () {
      Get.offNamed('/login');
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 10),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset('assets/newlogo.jpeg', width: 60),
                  const SizedBox(width: 10),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: const [
                      Text(
                        'लघु जल संसाधन विभाग',
                        style: TextStyle(
                            fontSize: 18,
                            color: Colors.red,
                            fontWeight: FontWeight.bold),
                      ),
                      Text(
                        'Minor Water Resources Department | Govt. of Bihar',
                        style: TextStyle(fontSize: 12, color: Colors.grey),
                      ),
                    ],
                  ),
                  Column(
                    mainAxisAlignment: MainAxisAlignment.center,

                  )
                ],
              ),
            ),
            const SizedBox(height: 80),

            const SizedBox(height: 200),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: const [
                Text('Loading...', style: TextStyle(color: Colors.grey)),
                SizedBox(width: 10),
                CircularProgressIndicator(color: Colors.orange),
              ],
            ),
            const Spacer(),
            Padding(
              padding: const EdgeInsets.only(bottom: 20.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Image.asset('assets/govbihar.png', width: 80),
                  const SizedBox(width: 20),
                  Image.asset('assets/niclogo.jpg', width: 200),
                ],
              ),
            )
          ],
        ),
      ),
    );
  }
}
