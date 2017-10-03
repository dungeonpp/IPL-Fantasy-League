function notification_count(tokenName,tokenValue) {
    var csrf = tokenName+"="+tokenValue;
    $.ajax({
        type: "POST",
        url: base_url + "notification/notification_count",
        data:  csrf ,
        success: function (response) {
            if (response == "login_error") {
                window.location.reload();
            }
            else {
                if (response != "0") {
                    //$(".notification-holder").show();
                    $(".noti-count").show().text(response);
                }
                else if (response == "0") {
                    $(".notification-holder").hide();
                    $(".noti-count").hide()
                }
            }
        }
    });
}

function delete_notification(notification_id,tokenName,tokenValue) {
    var csrf = tokenName+"="+tokenValue;
    $.ajax({
        type: "POST",
        url: base_url + "notification/delete_notification",
        data: "id=" + notification_id+"&"+csrf,
        success: function (response) {
            if (response == 1) {
                alert("Your Notification has been deleted successfully!");
                $(".notification_" + notification_id).remove();
            }
            else {
                alert("Something went wrong, Please try again later.");
            }
        }
    });
}

function user_notification(tokenName,tokenValue) {
    var csrf = tokenName+"="+tokenValue;
    $.ajax({
        type: "POST",
        url: base_url + "notification",
        data:  csrf ,
        success: function (response) {
            $(".noti-content").html("");
            $(".noti-content").html(response);
        }
    });
}

function notification_read(notification,tokenName,tokenValue, successCallback) {
    var csrf = tokenName+"="+tokenValue;
    $.ajax({
        type: "POST",
        url: base_url + "notification/notification_read",
        data: "notification=" + notification+"&"+csrf,
        success: successCallback
    });
}
