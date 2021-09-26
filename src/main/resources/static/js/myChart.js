

new Chart(document.getElementById("myPieChart"),
		{
	type="pie",
	data={
			  labels: ['January','February','March'],
			  datasets: [{
			    label: 'My First dataset',
			    backgroundColor: 'rgb(255, 99, 132)',
			    borderColor: 'rgb(255, 99, 132)',
			    data: [0, 10, 5, 2, 20, 30, 45]
			  }]
		},
	options={}
});