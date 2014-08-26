# com.amazon.aws

Amazon S3 is cloud storage for the Internet. It is designed to make web-scale computing easier for developers.

Amazon S3 provides a simple web-services interface that can be used to store and retrieve any amount of data, at any time, from anywhere on the web. It gives any developer access to the same highly scalable, reliable, secure, fast, inexpensive infrastructure that Amazon uses to run its own global network of web sites. The service aims to maximize benefits of scale and to pass those benefits on to developers.

The plugin defines a global `AWS` object, which is entry-point for any data operations.

Although the object is in the global scope, it is not available until after the `deviceready` event.

    document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
        console.log(device.cordova);
    }


## Configuration
By default, you can set global configuration by updating the `AWS.config` object with new settings. The most common settings are:

* credentials — the credentials object that contains authentication keys.
* region — to set the region for requests
* sslEnabled — whether SSL is enabled or not
* maxRetries — to control the number of retries for a request


More configuration settings can be found in the  [API reference documentation](http://docs.aws.amazon.com/AWSJavaScriptSDK/latest/frames.html).


## Getting Started

All requests made through the SDK are asynchronous and use a callback interface. Each service method that kicks off a request can accept a callback as the last parameter with the signature function(error, data) { ... }. This callback will be called when the response or error data is available.

For example, the following service method can be called with a standard callback to retrieve the response data or error:


    new AWS.S3().listObjects({Bucket: 'myBucket'}, function(error, data) {
      if (error) {
        console.log(error); // an error occurred
      } else {
        console.log(data); // request succeeded
      }
    });


The error and data parameters are described in the "Response Object" section below.

Note that if you do not specify a callback, the operation will return an AWS.Request object that must be manually sent using the send() method:


    // create the AWS.Request object
    var request = new AWS.S3().listObjects({Bucket: 'myBucket'});

    // register a callback to report on the data
    request.on('success', function(resp) {
      console.log(resp.data); // log the successful data response
    });

    // send the request
    request.send();



In order to make requests, once you have obtained the credentials from aws console. You need to set it in the following way before making autheticated calls:

    AWS.config.update({accessKeyId: '## YOU ACCESS KEY ##', secretAccessKey: '## YOUR SECRET ##'});


Once completed, you can make requests in the following way:

      var s3 = new AWS.S3();

      var params = {
        Bucket: 'sample-bucket' /* required */
      };
      s3.createBucket(params, function(err, data) {
        console.log(JSON.stringify(data));
      });


It is highly recommended to check out the offical [getting started guide](http://docs.aws.amazon.com/AWSJavaScriptSDK/guide/browser-making-requests.html).


### Supported Platforms

* iOS
* Android
