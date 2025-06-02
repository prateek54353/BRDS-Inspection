// File: app/routes/app_routes.dart
part of 'app_pages.dart';

abstract class Routes {
  Routes._();
  static const SPLASH = _Paths.SPLASH;
  static const LOGIN = _Paths.LOGIN;
  static const HOME = _Paths.HOME;
  static const CHANGE_PASSWORD = _Paths.CHANGE_PASSWORD;
  static const REPORT = _Paths.REPORT;
  static const UPLOAD = _Paths.UPLOAD;
  static const VIEW_REPORT = _Paths.VIEW_REPORT;
  static const DASHBOARD = _Paths.DASHBOARD;
  static const INSPECTION_FORM = _Paths.INSPECTION_FORM;
}

abstract class _Paths {
  _Paths._();
  static const SPLASH = '/splash';
  static const LOGIN = '/login';
  static const HOME = '/home';
  static const CHANGE_PASSWORD = '/change-password';
  static const REPORT = '/report';
  static const UPLOAD = '/upload';
  static const VIEW_REPORT = '/view-report';
  static const DASHBOARD = '/dashboard';
  static const INSPECTION_FORM = '/inspection-form';
}