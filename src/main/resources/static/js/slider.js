'use strict';

document.getElementById('range0').addEventListener('change', function() {
  document.getElementById('range-value0').innerHTML = this.value;
  getTally();
});

document.getElementById('range1').addEventListener('change', function() {
  document.getElementById('range-value1').innerHTML = this.value;
  getTally();
});

document.getElementById('range2').addEventListener('change', function() {
  document.getElementById('range-value2').innerHTML = this.value;
  getTally();
});

document.getElementById('range3').addEventListener('change', function() {
  document.getElementById('range-value3').innerHTML = this.value;
  getTally();
});

document.getElementById('range4').addEventListener('change', function() {
  document.getElementById('range-value4').innerHTML = this.value;
  getTally();
});

document.getElementById('range5').addEventListener('change', function() {
  document.getElementById('range-value5').innerHTML = this.value;
  getTally();
});

document.getElementById('range6').addEventListener('change', function() {
  document.getElementById('range-value6').innerHTML = this.value;
  getTally();
});

document.getElementById('range7').addEventListener('change', function() {
  document.getElementById('range-value7').innerHTML = this.value;
  getTally();
});

document.getElementById('range8').addEventListener('change', function() {
  document.getElementById('range-value8').innerHTML = this.value;
  getTally();
});

document.getElementById('range9').addEventListener('change', function() {
  document.getElementById('range-value9').innerHTML = this.value;
  getTally();
});

document.getElementById('range10').addEventListener('change', function() {
  document.getElementById('range-value10').innerHTML = this.value;
  getTally();
});

document.getElementById('range11').addEventListener('change', function() {
  document.getElementById('range-value11').innerHTML = this.value;
  getTally();
});

document.getElementById('range12').addEventListener('change', function() {
  document.getElementById('range-value12').innerHTML = this.value;
  getTally();
});

document.getElementById('range13').addEventListener('change', function() {
  document.getElementById('range-value13').innerHTML = this.value;
  getTally();
});

document.getElementById('range14').addEventListener('change', function() {
  document.getElementById('range-value14').innerHTML = this.value;
  getTally();
});

document.getElementById('range15').addEventListener('change', function() {
  document.getElementById('range-value15').innerHTML = this.value;
  getTally();
});

document.getElementById('range16').addEventListener('change', function() {
  document.getElementById('range-value16').innerHTML = this.value;
  getTally();

});

function getTally() {
    var sum = 0;
    for(var i=0; i<17; i++){
       sum += parseInt(document.getElementById('range-value'+i).innerHTML);
       console.log(sum);
    }
    document.getElementById('finalScore').innerHTML = sum;
}

document.getElementById('finalScore').innerHTML = 0;