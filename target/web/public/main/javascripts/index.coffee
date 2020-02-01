ws = new WebSocket $("body").data("ws-url")

  ws.onmessage = (event) ->
    message = event.data
    console.log(message)
    display(message)

  display = (message) ->
    $("#msg_holder").text(message)