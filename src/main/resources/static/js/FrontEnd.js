function SelectSort(SelList){
	var ID='';
	var label='';
	for (x=0; x < SelList.length - 1; x++){
		for (y=x + 1; y < SelList.length; y++){
			if (SelList[x].value > SelList[y].value){
				// Swap rows
				ID=SelList[x].value;
				label=SelList[x].label;
				SelList[x].value=SelList[y].value;
				SelList[x].label=SelList[y].label;
				SelList[y].value=ID;
				SelList[y].label=label;
	        }
	    }
	}
}

$(function() {

	var suggestions = [];

	$.getJSON("medList.json", function(data) {
		$.each(data, function(i, f) {
			suggestions.push({label: f.BothNames, value: f.GenericName});
		});
	});

	$("#searchbox").autocomplete({
		source: suggestions,
		autoFocus:true,
		select: function(event, suggestion) {
			$("#storedMeds").append("<option value=" + suggestion.item.value + ">" + suggestion.item.label + "</option>");
			suggestions = $.grep(suggestions,function(val){
				if(val.value != suggestion.item.value)
					return val;
			}); 
			$("#searchbox").autocomplete("option", "source", suggestions)
			return false
		}
	});

	$("#storedMeds").on("click", function() {
		suggestions.push({label: $("#storedMeds option:selected").text(), value: $("#storedMeds option:selected").val()});
		$("#storedMeds").find('option:selected').remove();
		SelectSort(suggestions);
	});

    
    $('input[type="checkbox"]').click(function(){
        var $this = $(this);
        var set = $this.add($this.prevUntil('li')).add($this.nextUntil('li'));
        set.not(this).prop('checked', false); 
    });


    // $('input[type=submit]').click(function(e){
    //     $('form').submit();
    //     return false;
    // });


    $("#SubmitButton").click(function() {

	//Lab Report//

	var temp = document.getElementById("LABREPORT");
	var lab = $(temp).serializeArray();
	console.log(JSON.stringify(lab));


	//Radiology Report//


	//Electrocardiogram
	temp = document.getElementById("ELECTROCARDIOGRAM");
	var electro = $(temp).serializeArray();
	console.log(JSON.stringify(electro));

	//Echocardiogram
	temp = document.getElementById("ECHOCARDIOGRAM");
	var echo = $(temp).serializeArray();
	console.log(JSON.stringify(electro));

	//X-Rays
	temp = document.getElementById("XRAYS");
	var xray = $(temp).serializeArray();
	console.log(JSON.stringify(xray));

	//Abdominal Ultrasound
	temp = document.getElementById("ABDOMINALULTRASOUND");
	var ultrasound = $(temp).serializeArray();
	console.log(JSON.stringify(ultrasound));

	//Abdominal Aortic Doppler
	temp = document.getElementById("ABDOMINALAORTICDOPPLER");
	var abdomDoppler = $(temp).serializeArray();
	console.log(JSON.stringify(abdomDoppler));

	//Lower Extremity Doppler
	temp = document.getElementById("LOWEREXTREMITYDOPPLER");
	var lowerDoppler = $(temp).serializeArray();
	console.log(JSON.stringify(lowerDoppler));


	//Specialist Report//


	//Cardiologist Report
	temp = document.getElementById("CARDIOLOGISTREPORT");
	var cardio = $(temp).serializeArray();
	console.log(JSON.stringify(cardio));

	//Ophthalmologist Report
	temp = document.getElementById("OPHTHALMOLOGISTREPORT");
	var ophthal = $(temp).serializeArray();
	console.log(JSON.stringify(ophthal));

	//Pulmonologist Report
	temp = document.getElementById("PULMONOLOGISTREPORT");
	var pulmono = $(temp).serializeArray();
	console.log(JSON.stringify(pulmono));

	//Neurologist Report
	temp = document.getElementById("NEUROLOGISTREPORT");
	var neuro = $(temp).serializeArray();
	console.log(JSON.stringify(neuro));

	//Psychiatrist/Psychologist Report
	temp = document.getElementById("PSYCHREPORT");
	var psyche = $(temp).serializeArray();
	console.log(JSON.stringify(psyche));

	//Rheumatologist Report
	temp = document.getElementById("RHEUMATOLOGISTREPORT");
	var rheuma = $(temp).serializeArray();
	console.log(JSON.stringify(rheuma));

	//Podiatrist Report
	temp = document.getElementById("PODIATRISTREPORT");
	var podiatrist = $(temp).serializeArray();
	console.log(JSON.stringify(podiatrist));

    });



    // $('input[type=submit]').submit(function(){
    // 	$.post($(this).attr('action'), $(this).serialize(), function(json) {
    // 		alert(json);
    // 	}, 'json');
    // 	Console.log("Hi");
    // 	return false;
    // });
  //   $("form").submit(function(){
  //   $.post($(this).attr("action"), $(this).serialize(), function(jsonData){
  //     console.log(jsonData);
  //   }, "json");
  // });


    // $(document).ready(function () {
//     $("#SubmitButton").click(function () {


//     	var $form0 = $("#ECHOCARDIOGRAM")
//     	var $form1 = $("#ELECTROCARDIOGRAM")
//         var $form2 = $("#XRAYS");
//         $.post($form0.attr("action"), $form0.serialize(), function(jsonData){
//       		console.log(jsonData);
//     	}, "json");

//         $.post($form1.attr("action"), $form1.serialize(), function(jsonData){
//       		console.log(jsonData);
//     	}, "json");

//     	$.post($form2.attr("action"), $form2.serialize(), function(jsonData){
//       		console.log(jsonData);
//     	}, "json");
//     });
// });

 });