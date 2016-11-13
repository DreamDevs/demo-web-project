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

    $("#SubmitButton").click(function() {


    //Medicine List//

    var medList = [];
    $("#storedMeds option").each(function() {
    medList.push($(this).val());
	});
    console.log(medList);

	//Lab Report//

	var temp = document.getElementById("LABREPORT");
	var lab = $(temp).serializeArray();
	lab = JSON.stringify(lab);
	lab = lab.replace(/"name":/g, '');
	lab = lab.replace(/,"value"/g, '');
	console.log(lab);


	//Radiology Report//


	//Electrocardiogram
	temp = document.getElementById("ELECTROCARDIOGRAM");
	var electro = $(temp).serializeArray();
	electro = JSON.stringify(electro);
	electro = electro.replace(/"name":/g, '');
	electro = electro.replace(/,"value"/g, '');
	console.log(electro);

	//Echocardiogram
	temp = document.getElementById("ECHOCARDIOGRAM");
	var echo = $(temp).serializeArray();
	echo = JSON.stringify(echo);
	echo = echo.replace(/"name":/g, '');
	echo = echo.replace(/,"value"/g, '');
	console.log(echo);


	//X-Rays
	temp = document.getElementById("XRAYS");
	var xray = $(temp).serializeArray();
	xray = JSON.stringify(xray);
	xray = xray.replace(/"name":/g, '');
	xray = xray.replace(/,"value"/g, '');
	console.log(xray);


	//Abdominal Ultrasound
	temp = document.getElementById("ABDOMINALULTRASOUND");
	var ultrasound = $(temp).serializeArray();
	ultrasound = JSON.stringify(ultrasound);
	ultrasound = ultrasound.replace(/"name":/g, '');
	ultrasound = ultrasound.replace(/,"value"/g, '');
	console.log(ultrasound);


	//Abdominal Aortic Doppler
	temp = document.getElementById("ABDOMINALAORTICDOPPLER");
	var abdomDoppler = $(temp).serializeArray();
	abdomDoppler = JSON.stringify(abdomDoppler);
	abdomDoppler = abdomDoppler.replace(/"name":/g, '');
	abdomDoppler = abdomDoppler.replace(/,"value"/g, '');
	console.log(abdomDoppler);

	//Lower Extremity Doppler
	temp = document.getElementById("LOWEREXTREMITYDOPPLER");
	var lowerDoppler = $(temp).serializeArray();
	lowerDoppler = JSON.stringify(lowerDoppler);
	lowerDoppler = lowerDoppler.replace(/"name":/g, '');
	lowerDoppler = lowerDoppler.replace(/,"value"/g, '');
	console.log(lab);


	//Specialist Report//


	//Cardiologist Report
	temp = document.getElementById("CARDIOLOGISTREPORT");
	var cardio = $(temp).serializeArray();
	cardio = JSON.stringify(cardio);
	cardio = cardio.replace(/"name":/g, '');
	cardio = cardio.replace(/,"value"/g, '');
	console.log(cardio);

	//Ophthalmologist Report
	temp = document.getElementById("OPHTHALMOLOGISTREPORT");
	var ophthal = $(temp).serializeArray();
	ophthal = JSON.stringify(ophthal);
	ophthal = ophthal.replace(/"name":/g, '');
	ophthal = ophthal.replace(/,"value"/g, '');
	console.log(ophthal);


	//Pulmonologist Report
	temp = document.getElementById("PULMONOLOGISTREPORT");
	var pulmono = $(temp).serializeArray();
	pulmono = JSON.stringify(pulmono);
	pulmono = pulmono.replace(/"name":/g, '');
	pulmono = pulmono.replace(/,"value"/g, '');
	console.log(pulmono);

	//Neurologist Report
	temp = document.getElementById("NEUROLOGISTREPORT");
	var neuro = $(temp).serializeArray();
	neuro = JSON.stringify(neuro);
	neuro = neuro.replace(/"name":/g, '');
	neuro = neuro.replace(/,"value"/g, '');
	console.log(neuro);


	//Psychiatrist/Psychologist Report
	temp = document.getElementById("PSYCHREPORT");
	var psyche = $(temp).serializeArray();
	psyche = JSON.stringify(psyche);
	psyche = psyche.replace(/"name":/g, '');
	psyche = psyche.replace(/,"value"/g, '');
	console.log(psyche);


	//Rheumatologist Report
	temp = document.getElementById("RHEUMATOLOGISTREPORT");
	var rheuma = $(temp).serializeArray();
	rheuma = JSON.stringify(rheuma);
	rheuma = rheuma.replace(/"name":/g, '');
	rheuma = rheuma.replace(/,"value"/g, '');
	console.log(rheuma);

	//Podiatrist Report
	temp = document.getElementById("PODIATRISTREPORT");
	var podiatrist = $(temp).serializeArray();
	podiatrist = JSON.stringify(podiatrist);
	podiatrist = podiatrist.replace(/"name":/g, '');
	podiatrist = podiatrist.replace(/,"value"/g, '');
	console.log(podiatrist);


    });


 });