def get_ip_class(ip_address):
    octets = ip_address.split(".")
    # Convert the first octet to an integer
    try:
        first_octet = int(octets[0])
    except ValueError:
        return "Invalid IP", "N/A"
    
    # Check the class based on the first octet
    if 1 <= first_octet <= 126:
        return "Class A", "255.0.0.0"
    elif 128 <= first_octet <= 191:
        return "Class B", "255.255.0.0"
    elif 192 <= first_octet <= 223:
        return "Class C", "255.255.255.0"
    elif 224 <= first_octet <= 239:
        return "Class D (Multicast)", "N/A"
    elif 240 <= first_octet <= 254:
        return "Class E (Experimental)", "N/A"
    else:
        return "Invalid IP", "N/A"

def main():
    print("IPv4 Class Identification and Default Subnet Mask")
    ip_address = input("Enter an IPv4 address: ")
    ip_class, subnet_mask = get_ip_class(ip_address)
    if ip_class != "Invalid IP":
        print(f"IP Address Class: {ip_class}")
        print(f"Default Subnet Mask: {subnet_mask}")
    else:
        print("Invalid IP address entered.")

if __name__ == "__main__":
    main()
