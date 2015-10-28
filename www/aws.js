var exec = require('cordova/exec');
var channel = require('cordova/channel');

var utils = require('cordova/utils');

channel.onCordovaReady.subscribe(function() {
	exec(function(credentials){
		AWS.config.update({accessKeyId: credentials.accessKey, secretAccessKey: credentials.secretKey});
    	AWS.config.region = 'us-west-2';
	}, function(e) {
		utils.alert("[ERROR] Error initializing Cordova: " + e);
    }, "AWS", "getCredentials", []);
});

if (typeof module != 'undefined' && module.exports) {
  module.exports = AWS;
}
