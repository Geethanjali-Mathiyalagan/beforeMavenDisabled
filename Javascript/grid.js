var columns = [
	{ id: "apply", name: "Apply", field: "apply", formatter: linkFormatter }
];

var data = [
	{ id: 1, name: "Apply",field:1},

];

function linkFormatter() {
	
	return "<a href='/updateGrade'>Update</a>";
}

var options = {
	enableCellNavigation: true,
	enableColumnReorder: false
};

var grid = new Slick.Grid("#myGrid", data, columns, options);
