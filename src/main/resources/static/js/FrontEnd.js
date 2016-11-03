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
    	var dataString = $("#MEDICINELIST,#LABREPORT, #ELECTROCARDIOGRAM, #ECHOCARDIOGRAM, #XRAYS, #ABDOMINALULTRASOUND,\
    	 #ABDOMINALAORTICDOPPLER, #LOWEREXTREMITYDOPPLER, #CARDIOLOGISTREPORT, #OPHTHALMOLOGISTREPORT,\
    	 #PULMONOLOGISTREPORT,#NEUROLOGISTREPORT,#PSYCHREPORT, #RHEUMATOLOGISTREPORT, #PODIATRISTREPORT").serialize();
    	  console.log(dataString);
    	  alert(dataString);
    	 //console.log($("#ECHOCARDIOGRAM").serialize());
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