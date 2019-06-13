<h3>Add Book Form</h3>
<form action="AddBook" method="post" style="width: 300px">
	<div class="form-group">
		<label for="callno1">Callno</label> <input type="text"
			class="form-control" name="callno" id="callno1" placeholder="Callno" required="required" />
	</div>
	<div class="form-group">
		<label for="name1">Name</label> <input type="text"
			class="form-control" name="name" id="name1" placeholder="Name" required="required" />
	</div>
	<div class="form-group">
		<label for="author1">Author</label> <input type="text"
			class="form-control" name="author" id="author1" placeholder="Author" required="required" />
	</div>
	<div class="form-group">
		<label for="publisher1">Publisher</label> <input type="text"
			class="form-control" name="publisher" id="publisher1"
			placeholder="Publisher" required="required" />
	</div>
	<div class="form-group">
		<label for="quantity1">Quantity</label> <input type="number"
			class="form-control" name="quantity" id="quantity1"
			placeholder="Quantity" required="required" />
	</div>
	<button type="submit" class="btn btn-primary">Save Book</button>
</form>