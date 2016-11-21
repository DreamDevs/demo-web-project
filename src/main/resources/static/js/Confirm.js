$(function() {
    
    $('input[type="checkbox"]').click(function(){
        var $this = $(this);
        console.log($this);
        if(this.id === "Insulin_Aspart")
        	$('input:checkbox[id^="Insulin_Aspart"]:checked').not(this).attr('checked', false);
        if(this.id === "Insulin_Detemir")
        	$('input:checkbox[id^="Insulin_Detemir"]:checked').not(this).attr('checked', false);
        if(this.id === "Insulin_Glargine")
        	$('input:checkbox[id^="Insulin_Glargine"]:checked').not(this).attr('checked', false);
        if(this.id === "Insulin_Lispro")
        	$('input:checkbox[id^="Insulin_Lispro"]:checked').not(this).attr('checked', false);
    });

});