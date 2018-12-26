<header>
	<!-- Image and text -->
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img src="${images}/logo.jpg"
			width="120" height="40" class="d-inline-block align-top" alt="">
		</a>
		
		
		
		<c:if test="${adminDetails!=null}">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Category </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="addcategory">Add Category</a> <a
								class="dropdown-item" href="allcategories">All Categories</a>
							<div class="dropdown-divider"></div>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Sub Category </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="addsubcategory">Add SubCategory</a> <a
								class="dropdown-item" href="allsubcategories">All SubCategories</a>
							<div class="dropdown-divider"></div>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Attributes </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Add Attribute</a> <a
								class="dropdown-item" href="#">All Attributes</a>
							<div class="dropdown-divider"></div>
						</div></li>
				</ul>
			</div>

		</c:if>
	</nav>
</header>