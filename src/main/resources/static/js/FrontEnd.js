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
});