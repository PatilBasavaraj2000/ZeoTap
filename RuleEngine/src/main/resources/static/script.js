// Eligibility form submission
document.getElementById('eligibilityForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById('name').value;
    const age = parseInt(document.getElementById('age').value, 10);
    const department = document.getElementById('department').value;
    const income = parseFloat(document.getElementById('income').value);
    const spending = parseFloat(document.getElementById('spending').value);

    const user = { name, age, department, income, spending };
    const eligibilityResult = checkEligibility(user);
    displayResult(eligibilityResult);
});

// Check user eligibility based on sample rules
function checkEligibility(user) {
    const { age, department, income, spending } = user;

    // Eligibility Rules
    const rule1 = ((age > 30 && department === 'Sales') || (age < 25 && department === 'Marketing')) &&
        (income > 50000 || spending > 5);
    const rule2 = (age > 30 && department === 'Marketing') &&
        (income > 20000 || spending > 5);

    return rule1 || rule2;
}

// Display the eligibility result
function displayResult(isEligible) {
    const resultDiv = document.getElementById('result');
    resultDiv.style.display = 'block';

    if (isEligible) {
        resultDiv.innerHTML = `<span style="color: green;">&#10003; You are eligible!</span>`; // Check mark symbol
    } else {
        resultDiv.innerHTML = `<span style="color: red;">&#10007; You are not eligible!</span>`; // Cross mark symbol
    }
}

// Clear button functionality
document.getElementById('clearBtn').addEventListener('click', function() {
    document.getElementById('eligibilityForm').reset(); // Clear form fields
    document.getElementById('result').style.display = 'none'; // Hide result
});

// Modal functionality
const rulesBtn = document.getElementById('rulesBtn');
const modal = document.getElementById('rulesModal');
const closeBtn = document.querySelector('.close');

rulesBtn.onclick = function() {
    modal.style.display = 'block';
}

closeBtn.onclick = function() {
    modal.style.display = 'none';
}

window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}
