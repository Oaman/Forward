var toastjs = {};
toastjs.os = {};
toastjs.os.isIOS = /iOS|iPhone|iPad|iPod/i.test(navigator.userAgent);
toastjs.os.isAndroid = !toastjs.os.isIOS;

toastjs.nativeInvoke = function(commandname, parameters) {
	console.log("toastjs takenativeaction")
	var request = {};
	request.name = commandname;
	request.param = parameters;
	if (window.toastjs.os.isAndroid) {
		console.log("android take native action" + JSON.stringify(request));
		window.toastwebview.nativeInvoke(JSON.stringify(request));
	} else {
		window.webkit.messageHandlers.toastwebview.postMessage(JSON.stringify(request))
	}
}

window.toastjs = toastjs