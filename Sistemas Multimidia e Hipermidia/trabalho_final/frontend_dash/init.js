(function () {
  // init.js

  // URL do arquivo de manifesto do vídeo
  var manifestURL = "http://127.0.0.1:5000/cdn/dash/lw-identidade/output.mpd";

  // Inicializa o player Dash.js
  var player = dashjs.MediaPlayer().create();
  player.initialize(document.querySelector("#videoPlayer"), manifestURL, true);

  // Aguarda o carregamento do manifesto do vídeo
  player.on(dashjs.MediaPlayer.events.MANIFEST_LOADED, function () {
    // Obtém as representações de qualidade disponíveis
    var representations = player.getBitrateInfoListFor("video");

    // Cria o seletor de qualidade de vídeo
    var qualitySelector = document.createElement("select");

    // Adiciona as opções de qualidade ao seletor
    representations.forEach(function (representation) {
      var option = document.createElement("option");
      option.value = representation.bitrate;
      option.text = representation.height + "p";
      qualitySelector.appendChild(option);
    });

    // Define a função para trocar a qualidade do vídeo
    qualitySelector.onchange = function () {
      var selectedBitrate = parseInt(qualitySelector.value);
      player.setQualityFor("video", selectedBitrate);
    };

    // Adiciona o seletor de qualidade à página
    document.body.appendChild(qualitySelector);
  });
})();