import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'dart:async';
import 'dart:io';
import 'app/routes/app_pages.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'Login App',
      debugShowCheckedModeBanner: false,
      themeMode: ThemeMode.system,
      theme: ThemeData.light(),
      darkTheme: ThemeData.dark(),
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

class _SplashScreenState extends State<SplashScreen> with WidgetsBindingObserver {
  bool _isCheckingInternet = false;
  bool _hasCheckedInternet = false;

  @override
  void initState() {
    super.initState();
    WidgetsBinding.instance.addObserver(this);
    _checkInternetAndNavigate();
  }

  @override
  void dispose() {
    WidgetsBinding.instance.removeObserver(this);
    super.dispose();
  }

  void _checkInternetAndNavigate() async {
    if (_isCheckingInternet) return;
    
    setState(() {
      _isCheckingInternet = true;
    });

    try {
      final result = await InternetAddress.lookup('example.com').timeout(
        const Duration(seconds: 5),
        onTimeout: () => throw TimeoutException('Connection timed out'),
      );
      if (result.isNotEmpty && result[0].rawAddress.isNotEmpty) {
        await Future.delayed(const Duration(seconds: 1));
        if (mounted) {
          Get.offNamed('/login');
        }
      }
    } catch (e) {
      if (mounted) {
        Get.defaultDialog(
          title: 'No Internet Connection',
          content: const Text(
            'Please check your internet connection and try again.',
            textAlign: TextAlign.center,
          ),
          textConfirm: 'Retry',
          onConfirm: () {
            Get.back();
            _checkInternetAndNavigate();
          },
          barrierDismissible: false,
        );
      }
    } finally {
      if (mounted) {
        setState(() {
          _isCheckingInternet = false;
          _hasCheckedInternet = true;
        });
      }
    }
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    if (state == AppLifecycleState.resumed && !_hasCheckedInternet) {
      _checkInternetAndNavigate();
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Header
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 10),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset(
                    'assets/newlogo.jpeg',
                    width: 60,
                    fit: BoxFit.cover,
                    cacheWidth: 60,
                    cacheHeight: 60,
                  ),
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
                ],
              ),
            ),

            const SizedBox(height: 200),

            // Loading Section
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Text('Loading...', style: TextStyle(color: Colors.grey)),
                SizedBox(width: 10),
                CircularProgressIndicator(color: Colors.orange),
              ],
            ),

            const Spacer(),

            // Footer logos
            Padding(
              padding: const EdgeInsets.only(bottom: 20.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: const [
                  Text('Loading...', style: TextStyle(color: Colors.grey)),
                  SizedBox(width: 10),
                  CircularProgressIndicator(color: Colors.orange),
                ],
              ),

              const Spacer(),

              // Footer logos
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
              ),
            ],
          ),
        ),
      ),
    );
  }
}