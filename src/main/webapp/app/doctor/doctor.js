'use strict';

angular.module('ausyaApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('doctor', {
        url: '/admin/doctor',
        templateUrl: 'app/doctor/doctor.html',
        controller: 'DoctorCtrl',
        sp: {
          authorize: {
            group: 'doctors'
          }
        }
      });
  });
