const modal = document.getElementById('modal');

const showAddModal = () => {
    modal.dataset.formType = 'add';
    modal.style.display = 'block';
};

const showEditModal = (product) => {
    const elements = modal.getElementsByTagName('input');
    for (const element of elements) {
        if (element.id === 'name') {
            element.value = product.name;
        } else if (element.id === 'price') {
            element.value = product.price;
        } else if (element.id === 'image-url') {
            element.value = product.image;
        }
    }
    modal.dataset.formType = 'edit';
    modal.dataset.productId = product.id;
    modal.style.display = 'block';
};


const hideAddModal = () => {
    modal.style.display = 'none';
    const elements = modal.getElementsByTagName('input');
    for (const element of elements) {
        element.value = '';
    }
}

const form = document.getElementById('form');

form.addEventListener('submit', (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    let product = {};
    for (const entry of formData.entries()) {
        product[entry[0]] = entry[1];
    }

    if (modal.dataset.formType === 'edit') {
        product['id'] = modal.dataset.productId;
        updateProduct(product);
        return;
    }

    createProduct(product);
});

// TODO: [1단계] 상품 관리 CRUD API에 맞게 변경
const createProduct = (product) => {
    axios.post(`/products`, product, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then((response) => {
        window.location.reload();
    })
    .catch((error) => {
        console.error(error);
    });
};

// TODO: [1단계] 상품 관리 CRUD API에 맞게 변경
const updateProduct = (product) => {

    axios.put(`/products/${product.id}`, product, {
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then((response) => {
        window.location.reload();
    })
    .catch((error) => {
        console.error(error);
    });
};


// TODO: [1단계] 상품 관리 CRUD API에 맞게 변경
const deleteProduct = (id) => {
    axios.delete(`/products/${id}`)
    .then((response) => {
        window.location.reload();
    })
    .catch((error) => {
        console.error(error);
    });
};
