

document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("btn").addEventListener("click", function(event) {
		let fileName = document.getElementById("fileName").value
		if (fileName) {
			fileName = encodeURIComponent(fileName)
			const imagetUrl = "/Servlet/img?fileName=" + fileName
			const thumbnail = document.getElementById("thumbnail")
			thumbnail.src = imagetUrl
		}
	})
	
})
