$(document).ready(function() {
    // Get today's date
    var today = new Date();
    var formattedToday = today.toISOString().split('T')[0]; // Format to YYYY-MM-DD

    // Get the date 7 days from now
    var sevenDaysFromNow = new Date();
    sevenDaysFromNow.setDate(today.getDate() + 7);
    var formattedSevenDaysFromNow = sevenDaysFromNow.toISOString().split('T')[0]; // Format to YYYY-MM-DD

    // Configure datetimepicker
    $(".datetimepicker").datetimepicker({
        minDate: formattedToday, // Set the minimum date to today
        maxDate: formattedSevenDaysFromNow, // Set the maximum date to 7 days from now
        format: 'Y-m-d H:i', // Format the date and time
        step: 15, // Time step in minutes
        onShow: function(ct) {
            // Ensure end time is always after start time
            var startTime = $('#startDatetime').datetimepicker('getValue');
            $('#endDatetime').datetimepicker('option', 'minDate', startTime);
        }
    });

    // Set end datetime min date to be always after start datetime
    $('#startDatetime').change(function() {
        var startTime = $(this).datetimepicker('getValue');
        $('#endDatetime').datetimepicker('option', 'minDate', startTime);
    });


    // Button click event handler
    $('#bookButton').click(function() {
        var startDatetime = $('#startDatetime').datetimepicker('getValue');
        var endDatetime = $('#endDatetime').datetimepicker('getValue');

        // For now, just show the selected values in an alert
        alert('Start Date and Time: ' + startDatetime + '\nEnd Date and Time: ' + endDatetime);

        // Here, you can add code to handle the booking submission
    });
});