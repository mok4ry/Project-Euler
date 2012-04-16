from numberwork import firstNpentagonal

NUM_PENTS = 2400
PENTS = dict()

def main():
    init_dict()
    for a in sorted(PENTS):
        for b in PENTS:
            if a + b in PENTS and a + 2*b in PENTS:
                print( a )
                return

def isPentagonal( n ):
    return n in FIRST_N_PENTS

def init_dict():
    FIRST_N_PENTS = firstNpentagonal( NUM_PENTS )
    for pent in FIRST_N_PENTS:
        PENTS[ pent ] = True

if __name__ == "__main__":
    main()

