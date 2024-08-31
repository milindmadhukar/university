const eventTypes = [
  {
    name: "Wedding",
    description: "Beautiful weddings for your special day.",
    image: "wedding.jpeg",
    price: 5000,
    services: ["catering", "photography"],
  },
  {
    name: "Conference",
    description: "Professional conferences for your business.",
    image: "conference.jpg",
    price: 10000,
    services: ["catering", "photography", "entertainment"],
  },
  {
    name: "Party",
    description: "Fun parties for your celebrations.",
    image: "party.jpg",
    price: 2000,
    services: ["entertainment"],
  },
];

const eventTypesElement = document.getElementById("eventTypes");
eventTypes.forEach((eventType) => {
  const eventTypeElement = document.createElement("div");
  eventTypeElement.classList.add("eventType");
  eventTypeElement.innerHTML = `
          <img src="${eventType.image}" alt="${eventType.name}">
          <h3>${eventType.name}</h3>
          <p>${eventType.description}</p>
          <p>$${eventType.price}</p>
        `;
  eventTypesElement.appendChild(eventTypeElement);
});

// Past Events.

const pastEventsElement = document.getElementById("pastEvents");
const pastEventsDropdownElement = document.getElementById("pastEventsDropdown");

pastEventsDropdownElement.addEventListener("change", () => {
  pastEventsElement.innerHTML = "";

  console.log(eventTypes);

  const pastEvents = eventTypes.filter((eventType) => {
    console.log(eventType.name, pastEventsDropdownElement.value);
    return eventType.name === pastEventsDropdownElement.value;
  });

  console.log(pastEvents);

  pastEvents.forEach((pastEvent) => {
    const pastEventElement = document.createElement("div");
    pastEventElement.classList.add("pastEvent");
    pastEventElement.innerHTML = `
            <img src="${pastEvent.image}" alt="${pastEvent.name}">
            <h3>${pastEvent.name}</h3>
            <p>${pastEvent.description}</p>
            <p>$${pastEvent.price}</p>
          `;
    pastEventsElement.appendChild(pastEventElement);
  });
});


const eventDetailsElement = document.getElementById("eventDetails");
eventTypesElement.addEventListener("click", (event) => {
  if (event.target.classList.contains("eventType")) {
    const eventType = eventTypes.find(
      (eventType) =>
        eventType.name === event.target.querySelector("h3").textContent,
    );
    eventDetailsElement.innerHTML = `
            <img src="${eventType.image}" alt="${eventType.name}">
            <h3>${eventType.name}</h3>
            <p>${eventType.description}</p>
            <p>$${eventType.price}</p>
          `;
  }
});

const filterOptionsElement = document.getElementById("filterOptions");
const contactFormElement = document.getElementById("contactForm");
const cartElement = document.getElementById("cart");


filterOptionsElement.addEventListener("change", () => {
  const services = Array.from(
    filterOptionsElement.querySelectorAll('input[type="checkbox"]:checked'),
  ).map((checkbox) => checkbox.id);
  const budget = filterOptionsElement.querySelector(
    'input[type="radio"]:checked',
  ).value;

const filteredEventTypes = eventTypes.filter((eventType) => {
  return (
    services.every((service) => eventType.services.includes(service)) &&
    ((budget === "under5000" && eventType.price < 5000) ||
      (budget === "5000to10000" &&
        eventType.price >= 5000 &&
        eventType.price <= 10000) ||
      (budget === "above10000" && eventType.price > 10000))
  );
});

  eventTypesElement.innerHTML = "";
  filteredEventTypes.forEach((eventType) => {
    const eventTypeElement = document.createElement("div");
    eventTypeElement.classList.add("eventType");
    eventTypeElement.innerHTML = `
            <img src="${eventType.image}" alt="${eventType.name}">
            <h3>${eventType.name}</h3>
            <p>${eventType.description}</p>
            <p>$${eventType.price}</p>
          `;
    eventTypesElement.appendChild(eventTypeElement);
  });

  eventDetailsElement.innerHTML = "";
});

contactFormElement.addEventListener("submit", (event) => {
  event.preventDefault();

  const name = contactFormElement.querySelector("#name").value;
  const email = contactFormElement.querySelector("#email").value;
  const phone = contactFormElement.querySelector("#phone").value;
  const eventType = contactFormElement.querySelector("#eventType").value;

  cartElement.innerHTML = `
          <p>Name: ${name}</p>
          <p>Email: ${email}</p>
          <p>Phone Number: ${phone}</p>
          <p>Event Type: ${eventType}</p>
        `;
});
