import ipaddress

def ip_to_int(ip):
    """Convert an IPv4 address to an integer."""
    return int(ipaddress.IPv4Address(ip))

def int_to_ip(num):
    """Convert an integer back to an IPv4 address."""
    return str(ipaddress.IPv4Address(num))

def calculate_ip_groups(ip_cidr, num_subgroups):
    """Calculate subgroups of IP addresses based on CIDR notation."""
    network = ipaddress.IPv4Network(ip_cidr, strict=False)
    total_addresses = network.num_addresses

    if num_subgroups > total_addresses:
        return "Too many subgroups for available addresses."

    group_size = total_addresses // num_subgroups
    subgroups = []
    current_ip_int = ip_to_int(str(network.network_address))

    for i in range(num_subgroups):
        first_ip_int = current_ip_int
        last_ip_int = current_ip_int + group_size - 1
        current_ip_int += group_size

        first_ip = int_to_ip(first_ip_int)
        last_ip = int_to_ip(last_ip_int)

        subgroups.append({
            "Group": i + 1,
            "First IP": first_ip,
            "Last IP": last_ip,
            "Total Addresses": group_size
        })

    return subgroups

def display_ip_groups(ip_cidr, num_subgroups):
    """Display the calculated IP address groups."""
    subgroups = calculate_ip_groups(ip_cidr, num_subgroups)
    if isinstance(subgroups, str):
        print(subgroups)
    else:
        print(f"IP Address Grouping for {ip_cidr} into {num_subgroups} subgroups:\n")
        for group in subgroups:
            print(f"Group {group['Group']}:")
            print(f"  First IP Address: {group['First IP']}")
            print(f"  Last IP Address: {group['Last IP']}")
            print(f"  Total Addresses: {group['Total Addresses']}\n")

# Prompt user for input
if __name__ == "__main__":
    ip_cidr = input("Enter an IP address with CIDR notation (e.g., 192.168.1.0/24): ")
    num_subgroups = int(input("Enter the number of subgroups: "))
    display_ip_groups(ip_cidr, num_subgroups)
