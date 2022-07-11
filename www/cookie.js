/*
 * @Author: 夏金洵
 * @Date: 2022-06-08 10:29:54
 * @LastEditTime: 2022-07-11 11:44:26
 * @LastEditors: 夏金洵
 * @Description: 
 * @可以输入预定的版权声明、个性签名、空行等
 */
var exec = require('cordova/exec');

exports.setCookie = function (arg0,arg1, success, error) {
    exec(success, error, 'Cookie', 'setCookie', [arg0,arg1]);
};