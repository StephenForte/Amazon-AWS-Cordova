/********* CDVAmazon.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface CDVAmazon : CDVPlugin

- (void)getCredentials:(CDVInvokedUrlCommand*)command;

@end

@implementation CDVAmazon

- (void)getCredentials:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    
     NSString *accessKey = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"AccessKey"];

     NSString *secretKey = [[[NSBundle mainBundle] infoDictionary] objectForKey:@"SecretKey"];
    
    
    NSDictionary *result =[NSDictionary dictionaryWithObjectsAndKeys:accessKey, @"accessKey", secretKey, @"secretKey", nil];

    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:result];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
