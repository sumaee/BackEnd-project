document.querySelector("#open-regist").addEventListener("click", function () {
	document.querySelector("#modal-regist").classList.remove("hidden");
});

document.querySelector("#close-regist").addEventListener("click", function () {
	document.querySelector("#modal-regist").classList.add("hidden");
});
const setEL = () => {
		  var reviewall = document.querySelectorAll(".reviewli");
		  var editall = document.querySelectorAll(".edit");
		  var modalcloseall = document.querySelectorAll(".cancel");
		  for (var i = 0; i < reviewall.length; i++) {
		    reviewall[i].addEventListener("click", function (e) {
		      var idx = e.target.parentNode.id.split("review")[1];
		      document.querySelector(`#review${idx}context`).classList.toggle("hidden")
		    });
		    
		    
		    modalcloseall[i].addEventListener("click", function (e) {
		      var idx = e.target.id.split("close-edit")[1];
		      document.querySelector(`#modal-edit${idx}`).classList.toggle("hidden")
		    });
		  }
		  
		  for(var i=0; i<reviewall.length; i++){
			  editall[i].addEventListener("click", function (e) {
		    	
		      var idx = e.target.id.split("edit")[1];
		      document.querySelector(`#modal-edit${idx}`).classList.toggle("hidden")
		    });
		  }
		  
		}
setEL();
		//리뷰 불러오기
		//리뷰등록 modal 창
