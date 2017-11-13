package de.christianhartmann.symbol;

public class Symbol {

    private SymbolType symbolType;
    private SymbolType loosesAgainst;
    private SymbolType winsAgainst;

    private Symbol(Builder builder) {
        this.symbolType = builder.symbolType;
        this.loosesAgainst = builder.loosesAgainst;
        this.winsAgainst = builder.winsAgainst;
    }

    public SymbolType symbolType() {
        return symbolType;
    }

    public SymbolType loosesAgainst() {
        return loosesAgainst;
    }

    public SymbolType winsAgainst() {
        return winsAgainst;
    }

    public static Symbol.Builder builder() {
        return new Symbol.Builder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        if (symbolType != symbol.symbolType) return false;
        if (loosesAgainst != symbol.loosesAgainst) return false;
        return winsAgainst == symbol.winsAgainst;
    }

    @Override
    public int hashCode() {
        int result = symbolType.hashCode();
        result = 31 * result + (loosesAgainst != null ? loosesAgainst.hashCode() : 0);
        result = 31 * result + winsAgainst.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbolType=" + symbolType +
                ", loosesAgainst=" + loosesAgainst +
                ", winsAgainst=" + winsAgainst +
                '}';
    }

    public static class Builder {
        private SymbolType symbolType;
        private SymbolType loosesAgainst;
        private SymbolType winsAgainst;

        public Builder symbolType(SymbolType symbolType) {
            this.symbolType = symbolType;
            return this;
        }

        public Builder loosesAgainst(SymbolType loosesAgainst) {
            this.loosesAgainst = loosesAgainst;
            return this;
        }

        public Builder winsAgainst(SymbolType winsAgainst) {
            this.winsAgainst = winsAgainst;
            return this;
        }

        public Symbol build() {
            if (symbolType==null) {
                throw new IllegalArgumentException("Please provide a symbol of the player.");
            }
            if (loosesAgainst==null) {
                throw new IllegalArgumentException("Please provide a symbol of whom the player looses against.");
            }
            if (winsAgainst==null) {
                throw new IllegalArgumentException("Please provide a symbol of whom the player wins against.");
            }
            return new Symbol(this);
        }
    }
}
